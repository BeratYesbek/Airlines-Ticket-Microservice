package com.beratyesbek.airlinesTicket.dao;

import com.beratyesbek.airlinesTicket.models.BoughtTicket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoughtTicketDao extends JpaRepository<BoughtTicket, Integer> {
}
