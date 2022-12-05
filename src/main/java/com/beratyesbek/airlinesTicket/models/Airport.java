package com.beratyesbek.airlinesTicket.models;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;
import lombok.*;

import java.util.List;
import java.util.Set;

import javax.persistence.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
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

    @OneToOne(mappedBy = "from",fetch = FetchType.LAZY)
    @JsonIgnore
    private Ticket from;

    @OneToOne(mappedBy = "to",fetch = FetchType.LAZY)
    @JsonIgnore
    private Ticket to;
}
