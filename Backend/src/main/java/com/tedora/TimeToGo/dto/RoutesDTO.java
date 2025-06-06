package com.tedora.TimeToGo.dto;

import com.tedora.TimeToGo.entity.Cities;

public class RoutesDTO {
    private Long routeId;
    private String routeNo;
    private Long startCityId;
    private Long endCityId;

    public RoutesDTO() {}

    public RoutesDTO(Long routeId, String routeNo, Long startCityId, Long endCityId) {
        this.routeId = routeId;
        this.routeNo = routeNo;
        this.startCityId = startCityId;
        this.endCityId = endCityId;
    }

    public Long getRouteId() { return routeId; }
    public void setRouteId(Long routeId) { this.routeId = routeId; }

    public String getRouteNo() { return routeNo; }
    public void setRouteNo(String routeNo) { this.routeNo = routeNo; }

    public Long getStartCityId() { return startCityId; }
    public void setStartCityId(Long startCityId) { this.startCityId = startCityId; }

    public Long getEndCityId() { return endCityId; }
    public void setEndCityId(Long endCityId) { this.endCityId = endCityId; }
}
