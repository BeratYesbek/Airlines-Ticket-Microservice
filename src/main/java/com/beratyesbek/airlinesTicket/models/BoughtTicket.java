package com.beratyesbek.airlinesTicket.models;

import com.google.type.DateTime;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.UUID;

@Entity
@Data
@Table(name = "bought_tickets")
public class BoughtTicket {

    @Id
    @Column(name = "bought_ticket_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int boughtTicketId;

    @GeneratedValue(generator = "uuid2", strategy = GenerationType.AUTO)
    @GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "checking_code", columnDefinition = "VARCHAR(255)", unique = true, nullable = false)
    private String checkingCode = UUID.randomUUID().toString();

    @Column(name = "full_name",nullable = false)
    private String fullName;

    @ManyToOne
    @JoinColumn(name = "ticket_id")
    private Ticket ticket;

    @Column(name = "user_email",nullable = false)
    private String userEmail;

    @Column(name = "identity_number",nullable = false)
    private String identityNumber;

    @Column(name = "seat_number")
    private int seatNumber;

    @Column(name = "seat_group",nullable = false)
    private char seatGroup;

    @Column(name = "price",nullable = false)
    private BigDecimal price;

    @Column(name = "phone_number",nullable = false)
    private String phoneNumber;

    @Column(name = "card_number",nullable = false)
    private String cardNumber;

    @Column(name = "card_year",nullable = false)
    private int cardYear;

    @Column(name = "card_month",nullable = false)
    private int cardMonth;

    @Column(name = "cvv",nullable = false)
    private int cvv;

    @Column(name = "card_name",nullable = false)
    private String cardName;

    @Column(name = "created_at", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP",nullable = false)
    private Date createdAt = new Date();
}
