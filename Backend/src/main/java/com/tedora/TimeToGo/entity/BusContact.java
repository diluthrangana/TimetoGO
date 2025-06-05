package com.tedora.TimeToGo.entity;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "buscontact")
public class BusContact {

    @Id
    @Column(name = "busId")
    private String busId;

    @Column(name = "driver")
    private String driver;

    @Column(name = "phoneNo")
    private String phoneNo;

    @OneToMany(mappedBy = "busContact", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Schedules> schedules;

    public BusContact() {
    }

    public BusContact(String busId, String driver, String phoneNo) {
        this.busId = busId;
        this.driver = driver;
        this.phoneNo = phoneNo;
    }

    // Getters and Setters
    public String getBusId() { return busId; }
    public void setBusId(String busId) { this.busId = busId; }

    public String getDriver() { return driver; }
    public void setDriver(String driver) { this.driver = driver; }

    public String getPhoneNo() { return phoneNo; }
    public void setPhoneNo(String phoneNo) { this.phoneNo = phoneNo; }

    public List<Schedules> getSchedules() { return schedules; }
    public void setSchedules(List<Schedules> schedules) { this.schedules = schedules; }
}
