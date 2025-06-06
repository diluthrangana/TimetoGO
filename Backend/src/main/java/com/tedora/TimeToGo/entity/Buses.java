package com.tedora.TimeToGo.entity;

import com.tedora.TimeToGo.enums.*;
import jakarta.persistence.*;

@Entity
@Table(name = "buses")
public class Buses {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "busId", nullable = false, updatable = false)
    private Long busId;

    @Column(name = "busNumber", nullable = false, unique = true)
    private String busNumber;

    @Column(name = "capacity", nullable = true)
    private Integer capacity;

    @Enumerated(EnumType.STRING)
    @Column(name = "ownership")
    private Ownership ownership;

    @Enumerated(EnumType.STRING)
    @Column(name = "busClass")
    private BusClass busClass;

    @Enumerated(EnumType.STRING)
    @Column(name = "busType")
    private BusType busType;

    @Enumerated(EnumType.STRING)
    @Column(name = "manufacturer", nullable = false)
    private Manufacturer manufacturer;

    /* ---------- constructors ---------- */
    public Buses() {}

    public Buses(Long busId, String busNumber, Integer capacity,
                 Ownership ownership, BusClass busClass,
                 BusType busType, Manufacturer manufacturer) {
        this.busId = busId;
        this.busNumber = busNumber;
        this.capacity = capacity;
        this.ownership = ownership;
        this.busClass = busClass;
        this.busType = busType;
        this.manufacturer = manufacturer;
    }

    /* ---------- getters & setters ---------- */
    public Long getBusId() { return busId; }
    public void setBusId(Long busId) { this.busId = busId; }

    public String getBusNumber() { return busNumber; }
    public void setBusNumber(String busNumber) { this.busNumber = busNumber; }

    public Integer getCapacity() { return capacity; }
    public void setCapacity(Integer capacity) { this.capacity = capacity; }

    public Ownership getOwnership() { return ownership; }
    public void setOwnership(Ownership ownership) { this.ownership = ownership; }

    public BusClass getBusClass() { return busClass; }
    public void setBusClass(BusClass busClass) { this.busClass = busClass; }

    public BusType getBusType() { return busType; }
    public void setBusType(BusType busType) { this.busType = busType; }

    public Manufacturer getManufacturer() { return manufacturer; }
    public void setManufacturer(Manufacturer manufacturer) { this.manufacturer = manufacturer; }
}
