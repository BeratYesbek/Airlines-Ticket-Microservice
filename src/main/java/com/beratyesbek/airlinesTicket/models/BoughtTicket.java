package com.beratyesbek.airlinesTicket.models;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Data
public class BoughtTicket {

    @Id
    @Column(name = "bought_ticket_id")
    private int boughtTicketId;

    @ManyToOne
    @JoinColumn(name = "ticket_id")
    private Ticket ticket;

    @Column(name = "user_email")
    private String userEmail;

    @Column(name = "identity_number")
    private String identityNumber;

    @Column(name = "price")
    private BigDecimal price;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "created_at")
    private Date createdAt;
}
