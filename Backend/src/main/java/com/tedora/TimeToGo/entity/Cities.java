package com.tedora.TimeToGo.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "cities")
@Getter
@Setter
public class Cities {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cityId")
    private Long cityId;

    @Column(name = "cityName")
    private String cityName;
}
