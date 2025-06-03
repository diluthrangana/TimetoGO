package com.tedora.TimeToGo.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "schedules")
@Getter
@Setter
public class Schedules {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "scheduleId")
    private Long scheduleId;

    @Column(name = "routeId")
    private String routeId;

    @Column(name = "busId")
    private String busId;

    @Column(name = "startTime")
    private String startTime;

    @Column(name = "endTime")
    private String endTime;
}
