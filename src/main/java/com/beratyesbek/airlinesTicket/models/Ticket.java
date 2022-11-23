package com.beratyesbek.airlinesTicket.models;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Data
public class Ticket {
    @Id
    @Column(name = "ticket_id")
    private int ticketId;

    @ManyToOne
    @JoinColumn(name = "airport_id")
    @Column(name = "from")
    private Airport from;

    @ManyToOne
    @JoinColumn(name = "airport_id")
    @Column(name = "to")
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
