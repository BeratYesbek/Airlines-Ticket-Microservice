package com.beratyesbek.airlinesTicket.models;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Data
@Table(name = "bought_tickets")
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

    @Column(name = "card_number")
    private String cardNumber;

    @Column(name = "card_year")
    private int cardYear;

    @Column(name = "card_month")
    private int cardMonth;

    @Column(name = "cvv")
    private int cvv;

    @Column(name = "card_name")
    private String cardName;

    @Column(name = "created_at")
    private Date createdAt;
}
