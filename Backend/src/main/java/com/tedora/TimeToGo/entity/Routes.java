package com.tedora.TimeToGo.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "routes")
@Getter
@Setter
public class Routes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "routeId")
    private Long routeId;

    @Column(name = "routeNo")
    private String routeNo;

    @Column(name = "startLocation")
    private String startLocation;

    @Column(name = "endLocation")
    private String endLocation;
}
