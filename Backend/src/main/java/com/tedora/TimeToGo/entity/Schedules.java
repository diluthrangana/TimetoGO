package com.tedora.TimeToGo.entity;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "schedules")
public class Schedules {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "scheduleId")
    private Long scheduleId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "routeId", referencedColumnName = "routeId")
    private Routes route;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "busId", referencedColumnName = "busId")
    private BusContact busContact;

    @Column(name = "startTime")
    private String startTime;

    @Column(name = "endTime")
    private String endTime;

    @OneToMany(mappedBy = "schedule", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Bookings> bookings;

    public Schedules() {
    }

    public Schedules(Routes route, BusContact busContact, String startTime, String endTime) {
        this.route = route;
        this.busContact = busContact;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    // Getters and Setters
    public Long getScheduleId() { return scheduleId; }
    public void setScheduleId(Long scheduleId) { this.scheduleId = scheduleId; }

    public Routes getRoute() { return route; }
    public void setRoute(Routes route) { this.route = route; }

    public BusContact getBusContact() { return busContact; }
    public void setBusContact(BusContact busContact) { this.busContact = busContact; }

    public String getStartTime() { return startTime; }
    public void setStartTime(String startTime) { this.startTime = startTime; }

    public String getEndTime() { return endTime; }
    public void setEndTime(String endTime) { this.endTime = endTime; }

    public List<Bookings> getBookings() { return bookings; }
    public void setBookings(List<Bookings> bookings) { this.bookings = bookings; }
}
