package com.tedora.TimeToGo.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "stations")
@Getter
@Setter
public class Stations {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "stationId")
    private Long stationId;

    @Column(name = "stationName")
    private String stationName;
}
