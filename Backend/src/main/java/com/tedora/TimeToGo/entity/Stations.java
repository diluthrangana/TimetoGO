package com.tedora.TimeToGo.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "stations")
public class Stations {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "stationId")
    private Long stationId;

    @Column(name = "stationName")
    private String stationName;

    public Stations() {
    }

    public Stations(String stationName) {
        this.stationName = stationName;
    }

    // Getters and Setters
    public Long getStationId() { return stationId; }
    public void setStationId(Long stationId) { this.stationId = stationId; }

    public String getStationName() { return stationName; }
    public void setStationName(String stationName) { this.stationName = stationName; }
}