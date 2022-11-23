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
    private int ticketId;

    @ManyToMany(fetch = FetchType.LAZY)
    private Set<Airport> from;

    @ManyToMany(fetch = FetchType.LAZY)
    private Set<Airport> to;

    @Column(name = "price")
    private BigDecimal price;

    @Column(name = "companyName")
    private String companyName;

    @Column(name = "airPlaneName")
    private String airPlaneName;

    @Column(name = "flightDate")
    private Date flightDate;
}
