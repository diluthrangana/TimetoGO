package com.tedora.TimeToGo.entity;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "routes")
public class Routes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "routeId")
    private Long routeId;

    @Column(name = "routeNo")
    private String routeNo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "startLocation", referencedColumnName = "cityId")
    private Cities startCity;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "endLocation", referencedColumnName = "cityId")
    private Cities endCity;

    @OneToMany(mappedBy = "route", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Schedules> schedules;

    public Routes() {
    }

    public Routes(String routeNo, Cities startCity, Cities endCity) {
        this.routeNo = routeNo;
        this.startCity = startCity;
        this.endCity = endCity;
    }

    // Getters and Setters
    public Long getRouteId() { return routeId; }
    public void setRouteId(Long routeId) { this.routeId = routeId; }

    public String getRouteNo() { return routeNo; }
    public void setRouteNo(String routeNo) { this.routeNo = routeNo; }

    public Cities getStartCity() { return startCity; }
    public void setStartCity(Cities startCity) { this.startCity = startCity; }

    public Cities getEndCity() { return endCity; }
    public void setEndCity(Cities endCity) { this.endCity = endCity; }

    public List<Schedules> getSchedules() { return schedules; }
    public void setSchedules(List<Schedules> schedules) { this.schedules = schedules; }
}
