package com.beratyesbek.airlinesTicket.controllers;

import java.util.List;

import com.beratyesbek.airlinesTicket.dao.BoughtTicketDao;
import com.beratyesbek.airlinesTicket.dto.BoughtTicketCreateDto;
import com.beratyesbek.airlinesTicket.grpcService.DiscountGrpcService;
import com.beratyesbek.airlinesTicket.mailerService.NotifyService;
import com.beratyesbek.airlinesTicket.models.BoughtTicket;
import com.beratyesbek.grpc.DiscountResponse;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController
@RequestMapping("api/bought_tickets")
@AllArgsConstructor
public class BoughtTicketsController {
    private final BoughtTicketDao boughtTicketDao;
    private final DiscountGrpcService discountGrpcService;
    private final ModelMapper modelMapper;

    private final NotifyService notifyService;


    @PostMapping
    public ResponseEntity create(@RequestBody BoughtTicketCreateDto boughtTicketCreateDto) {
        BoughtTicket createdBoughtTicket = modelMapper.map(boughtTicketCreateDto, BoughtTicket.class);
        createdBoughtTicket.setBoughtTicketId(0);
        DiscountResponse discountResponse = discountGrpcService.getDiscount(createdBoughtTicket, boughtTicketCreateDto.getCode());
        if (discountResponse.getStatusCode()) {
            createdBoughtTicket.setPrice(BigDecimal.valueOf(discountResponse.getNewPRice()));
            BoughtTicket  boughtTicket = boughtTicketDao.save(createdBoughtTicket);
            // TODO change parameter that given sendNotify method
            notifyService.sendNotify(boughtTicket.getTicket().getCompanyName());
            return ResponseEntity.ok(boughtTicket);
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Your discount code is wrong");
    }

    @GetMapping
    public ResponseEntity<List<BoughtTicket>> getAll() {
        return ResponseEntity.ok(boughtTicketDao.findAll());
    }
}
