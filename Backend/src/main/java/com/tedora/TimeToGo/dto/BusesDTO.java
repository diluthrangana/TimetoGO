package com.tedora.TimeToGo.dto;

import com.tedora.TimeToGo.enums.BusClass;
import com.tedora.TimeToGo.enums.BusType;
import com.tedora.TimeToGo.enums.Manufacturer;
import com.tedora.TimeToGo.enums.Ownership;

/** Lightweight transfer object for Bus data */
public class BusesDTO {

    private Long busId;
    private String busNumber;
    private Integer capacity;
    private Ownership ownership;
    private BusClass busClass;
    private BusType busType;
    private Manufacturer manufacturer;


    public BusesDTO() {}

    public BusesDTO(Long busId, String busNumber, Integer capacity,
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
