package com.beratyesbek.airlinesTicket.controllers;

import java.util.List;

import com.beratyesbek.airlinesTicket.dao.BoughtTicketDao;
import com.beratyesbek.airlinesTicket.dao.TicketDao;
import com.beratyesbek.airlinesTicket.dto.BoughtTicketCreateDto;
import com.beratyesbek.airlinesTicket.grpcService.abstracts.CheckingGrpcService;
import com.beratyesbek.airlinesTicket.grpcService.abstracts.DiscountGrpcService;
import com.beratyesbek.airlinesTicket.mailerService.NotifyService;
import com.beratyesbek.airlinesTicket.models.BoughtTicket;
import com.beratyesbek.airlinesTicket.utilities.BoughtTicketDataHelper;
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
    private final TicketDao ticketDao;
    private final DiscountGrpcService discountGrpcService;
    private final CheckingGrpcService checkingGrpcService;
    private final ModelMapper modelMapper;
    private final NotifyService notifyService;


    @PostMapping
    public ResponseEntity create(@RequestBody BoughtTicketCreateDto boughtTicketCreateDto) {
        BoughtTicket createdBoughtTicket = modelMapper.map(boughtTicketCreateDto, BoughtTicket.class);
        createdBoughtTicket.setBoughtTicketId(0);
        DiscountResponse discountResponse = discountGrpcService.getDiscount(createdBoughtTicket, boughtTicketCreateDto.getCode());
        if (discountResponse.getStatusCode()) {
            createdBoughtTicket.setPrice(BigDecimal.valueOf(discountResponse.getNewPRice()));
            BoughtTicket boughtTicket = boughtTicketDao.save(createdBoughtTicket);
            boughtTicket.setTicket(ticketDao.findById(boughtTicket.getTicket().getTicketId()).get());
            checkingGrpcService.saveBoughtTicket(boughtTicket);
            String n = boughtTicket.getTicket().getFrom().getName();
            // TODO change parameter that given sendNotify method
            notifyService.sendNotify("Your ticket reserved successfully", BoughtTicketDataHelper.prepareHeadersDataForMailerService(boughtTicket));
            return new ResponseEntity(boughtTicket, HttpStatus.OK);
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Your discount code is wrong");
    }

    @GetMapping
    public ResponseEntity<List<BoughtTicket>> getAll() {
        return ResponseEntity.ok(boughtTicketDao.findAll());
    }
}
