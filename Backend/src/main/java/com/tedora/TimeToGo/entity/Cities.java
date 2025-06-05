package com.tedora.TimeToGo.entity;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "cities")
public class Cities {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cityId")
    private Long cityId;

    @Column(name = "cityName", nullable = false, unique = true)
    private String cityName;

    @OneToMany(mappedBy = "startCity", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Routes> startRoutes;

    @OneToMany(mappedBy = "endCity", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Routes> endRoutes;

    public Cities() {
    }

    public Cities(String cityName) {
        this.cityName = cityName;
    }

    // Getters and Setters
    public Long getCityId() { return cityId; }
    public void setCityId(Long cityId) { this.cityId = cityId; }

    public String getCityName() { return cityName; }
    public void setCityName(String cityName) { this.cityName = cityName; }

    public List<Routes> getStartRoutes() { return startRoutes; }
    public void setStartRoutes(List<Routes> startRoutes) { this.startRoutes = startRoutes; }

    public List<Routes> getEndRoutes() { return endRoutes; }
    public void setEndRoutes(List<Routes> endRoutes) { this.endRoutes = endRoutes; }
}
