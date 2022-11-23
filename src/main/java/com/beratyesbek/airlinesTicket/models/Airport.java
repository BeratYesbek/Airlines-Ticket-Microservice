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
    private int airportId;

    @NotNull
    @Column(name = "country")
    private String country;

    @NotNull
    @Column(name = "province")
    private String province;

    @NotNull
    @Column(name = "name")
    private String name;

    @ManyToMany(mappedBy = "from")
    private Set<Ticket> from;

    @ManyToMany(mappedBy = "to")
    private Set<Ticket> to;
}
