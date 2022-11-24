package com.beratyesbek.airlinesTicket.models;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;

@Entity
@Data
@Table(name = "tickets")
public class Ticket {
    @Id
    @Column(name = "ticket_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ticketId;

    @OneToOne(fetch = FetchType.LAZY)
    private Airport from;

    @OneToOne(fetch = FetchType.LAZY)
    private Airport to;

    @Column(name = "price")
    private BigDecimal price;

    @Column(name = "companyName")
    private String companyName;

    @Column(name = "airPlaneName")
    private String airPlaneName;

    @Column(name = "flightDate")
    private Date flightDate;
}
