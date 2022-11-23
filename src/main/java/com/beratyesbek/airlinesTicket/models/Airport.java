package com.beratyesbek.airlinesTicket.models;

import com.sun.istack.NotNull;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
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
}
