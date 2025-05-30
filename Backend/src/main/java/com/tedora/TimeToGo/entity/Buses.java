package com.tedora.TimeToGo.entity;
import com.tedora.TimeToGo.enums.BusClass;
import com.tedora.TimeToGo.enums.Ownership;
import com.tedora.TimeToGo.enums.Manufacturer;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="buses")
@Getter
@Setter
public class Buses {
    @Id
    @GeneratedValue
    @Column(name="busId", nullable = false, updatable = false)
    private int busId;

    @Column(name="busNumber", updatable = true)
    private String busNumber;

    @Column(name="capacity")
    private String capacity;

    @Enumerated(EnumType.STRING)
    @Column(name="ownership")
    private Ownership ownership;

    @Enumerated(EnumType.STRING)
    @Column(name="busClass")
    private BusClass busClass;

    @Enumerated(EnumType.STRING)
    @Column(name="busType")
    private BusType busType;

    @Enumerated(EnumType.STRING)
    @Column(name="manufacturer")
    private Manufacturer manufacturer;
}
