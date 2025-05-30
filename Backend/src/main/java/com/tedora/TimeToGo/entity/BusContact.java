package com.tedora.TimeToGo.entity;

import jakarta.persistence.*;
import lombok.data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="buscontact")
@Getter
@Setter
public class BusContact {
    @Id
    @Column


    @Column(name="driver")
    private String driver;

    @Column(name="phoneNo")
    private String phoneNo;


}
