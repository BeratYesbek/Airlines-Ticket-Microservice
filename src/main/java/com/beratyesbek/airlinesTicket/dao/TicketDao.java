package com.beratyesbek.airlinesTicket.dao;

import com.beratyesbek.airlinesTicket.models.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketDao extends JpaRepository<Ticket, Integer> {
}
