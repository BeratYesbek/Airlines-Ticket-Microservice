package com.beratyesbek.airlinesTicket.models;


import com.sun.istack.NotNull;
import lombok.Data;
import java.util.List;
import java.util.Set;

import javax.persistence.*;

@Entity
@Data
@Table(name = "airports")
public class Airport {

    @Id
    @Column(name = "airport_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int airportId;

    @Column(name = "country")
    private String country;

    @Column(name = "province")
    private String province;

    @Column(name = "name")
    private String name;

    @OneToOne(mappedBy = "from")
    private Ticket from;

    @OneToOne(mappedBy = "to")
    private Ticket to;
}
