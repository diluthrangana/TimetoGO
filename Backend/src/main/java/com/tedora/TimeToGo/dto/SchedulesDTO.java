package com.tedora.TimeToGo.dto;

public class SchedulesDTO {

    private Long scheduleId;
    private Long routeId;
    private String startTime;
    private String endTime;

    public SchedulesDTO() {}

    public SchedulesDTO(Long scheduleId, Long routeId, String startTime, String endTime) {
        this.scheduleId = scheduleId;
        this.routeId = routeId;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public Long getScheduleId() { return scheduleId; }
    public void setScheduleId(Long scheduleId) { this.scheduleId = scheduleId; }

    public Long getRouteId() { return routeId; }
    public void setRouteId(Long routeId) { this.routeId = routeId; }

    public String getStartTime() { return startTime; }
    public void setStartTime(String startTime) { this.startTime = startTime; }

    public String getEndTime() { return endTime; }
    public void setEndTime(String endTime) { this.endTime = endTime; }
}
