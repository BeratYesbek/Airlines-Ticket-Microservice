package com.beratyesbek.airlinesTicket.controllers;

import java.util.List;
import com.beratyesbek.airlinesTicket.dao.BoughtTicketDao;
import com.beratyesbek.airlinesTicket.dto.BoughtTicketCreateDto;
import com.beratyesbek.airlinesTicket.grpcService.DiscountGrpcService;
import com.beratyesbek.airlinesTicket.models.BoughtTicket;
import com.beratyesbek.grpc.DiscountResponse;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController
@RequestMapping(name = "api/bought_tickets")
public class BoughtTicketsController {
    private final BoughtTicketDao boughtTicketDao;
    private final DiscountGrpcService discountGrpcService;
    private final ModelMapper modelMapper;

    public BoughtTicketsController(BoughtTicketDao boughtTicketDao, DiscountGrpcService discountGrpcService, ModelMapper modelMapper) {
        this.boughtTicketDao = boughtTicketDao;
        this.discountGrpcService = discountGrpcService;
        this.modelMapper = modelMapper;
    }

    @PostMapping
    public ResponseEntity create(@RequestBody BoughtTicketCreateDto boughtTicketCreateDto) {
        BoughtTicket boughtTicket = modelMapper.map(boughtTicketCreateDto, BoughtTicket.class);
        DiscountResponse discountResponse = discountGrpcService.getDiscount(boughtTicket, boughtTicketCreateDto.getCode());
        if (discountResponse.getStatusCode()) {
            boughtTicket.setPrice(BigDecimal.valueOf(discountResponse.getNewPRice()));
            return ResponseEntity.ok(boughtTicketDao.save(boughtTicket));
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Your discount code is wrong");
    }

    @GetMapping
    public ResponseEntity<List<BoughtTicket>> getAll() {
        return ResponseEntity.ok(boughtTicketDao.findAll());
    }
}
