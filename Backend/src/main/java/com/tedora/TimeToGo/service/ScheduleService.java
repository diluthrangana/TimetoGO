package com.tedora.TimeToGo.service;

import com.tedora.TimeToGo.dto.SchedulesDTO;

import java.util.List;

public interface ScheduleService {

    List<SchedulesDTO> getAllSchedules();

    SchedulesDTO getScheduleByScheduleId(Long scheduleId);

    List<SchedulesDTO> getScheduleByStartTimeAndStartCity(String startTime, String startCity);

    List<SchedulesDTO> getScheduleByStartTimeAndRouteId(String startTime, Long routeId);

    List<SchedulesDTO> getSchedulesByRouteId(Long routeId);

    List<SchedulesDTO> getSchedulesByStartTime(String startTime);

    SchedulesDTO createSchedule(SchedulesDTO schedulesDTO);

    SchedulesDTO updateSchedule(Long scheduleId, SchedulesDTO schedulesDTO);

    void deleteSchedule(Long scheduleId);
}
