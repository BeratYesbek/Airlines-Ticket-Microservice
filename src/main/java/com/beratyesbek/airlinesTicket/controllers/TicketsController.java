package com.beratyesbek.airlinesTicket.controllers;

import com.beratyesbek.airlinesTicket.dao.TicketDao;
import com.beratyesbek.airlinesTicket.models.Ticket;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/tickets")
public class TicketsController {
    private final TicketDao ticketDao;

    public TicketsController(TicketDao ticketDao) {
        this.ticketDao = ticketDao;
    }

    @PostMapping
    public ResponseEntity<Ticket> create(@RequestBody Ticket ticket) {
        return ResponseEntity.ok(ticketDao.save(ticket));
    }

    @GetMapping
    public ResponseEntity<List<Ticket>> getAll() {
        return ResponseEntity.ok(ticketDao.findAll());
    }
}
