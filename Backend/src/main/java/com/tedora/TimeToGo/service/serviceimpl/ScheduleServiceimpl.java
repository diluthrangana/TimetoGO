package com.tedora.TimeToGo.service.serviceimpl;

import com.tedora.TimeToGo.dto.SchedulesDTO;
import com.tedora.TimeToGo.entity.Routes;
import com.tedora.TimeToGo.entity.Schedules;
import com.tedora.TimeToGo.repository.RoutesRepository;
import com.tedora.TimeToGo.repository.ScheduleRepository;
import com.tedora.TimeToGo.service.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ScheduleServiceimpl implements ScheduleService{

    @Autowired
    private ScheduleRepository scheduleRepository;

    @Autowired
    private RoutesRepository routeRepository;

    @Override
    public List<SchedulesDTO> getAllSchedules() {
        List<Schedules> schedulesList = scheduleRepository.findAll();
        return schedulesList.stream().map(this::mapToDTO).collect(Collectors.toList());
    }

    @Override
    public SchedulesDTO getScheduleByScheduleId(Long scheduleId) {
        Schedules s = scheduleRepository.findById(scheduleId)
                .orElseThrow(() -> new RuntimeException("Schedule not found with id " + scheduleId));
        return mapToDTO(s);
    }

    @Override
    public List<SchedulesDTO> getScheduleByStartTimeAndStartCity(String startTime, String startCity) {
        // You need a custom query to join schedules and routes and filter by route.startCity.cityName and schedule.startTime
        // Let's assume you add that query in ScheduleRepository (not shown here)
        throw new UnsupportedOperationException("Custom query for startTime and startCity not implemented");
    }

    @Override
    public List<SchedulesDTO> getScheduleByStartTimeAndRouteId(String startTime, Long routeId) {
        // Implement if required, or use custom query in repository
        throw new UnsupportedOperationException("Custom query for startTime and routeId not implemented");
    }

    @Override
    public List<SchedulesDTO> getSchedulesByRouteId(Long routeId) {
        List<Schedules> schedulesList = scheduleRepository.findByRouteRouteId(routeId);
        return schedulesList.stream().map(this::mapToDTO).collect(Collectors.toList());
    }

    @Override
    public List<SchedulesDTO> getSchedulesByStartTime(String startTime) {
        List<Schedules> schedulesList = scheduleRepository.findByStartTime(startTime);
        return schedulesList.stream().map(this::mapToDTO).collect(Collectors.toList());
    }

    @Override
    public SchedulesDTO createSchedule(SchedulesDTO schedulesDTO) {
        Schedules schedule = mapToEntity(schedulesDTO);

        // Fetch Route entity by routeId and assign to schedule
        Routes route = routeRepository.findById(schedulesDTO.getRouteId())
                .orElseThrow(() -> new RuntimeException("Route not found with id " + schedulesDTO.getRouteId()));
        schedule.setRoute(route);

        Schedules savedSchedule = scheduleRepository.save(schedule);
        return mapToDTO(savedSchedule);
    }

    @Override
    public SchedulesDTO updateSchedule(Long scheduleId, SchedulesDTO schedulesDTO) {
        Schedules existingSchedule = scheduleRepository.findById(scheduleId)
                .orElseThrow(() -> new RuntimeException("Schedule not found with id " + scheduleId));

        existingSchedule.setStartTime(schedulesDTO.getStartTime());
        existingSchedule.setEndTime(schedulesDTO.getEndTime());

        Routes route = routeRepository.findById(schedulesDTO.getRouteId())
                .orElseThrow(() -> new RuntimeException("Route not found with id " + schedulesDTO.getRouteId()));
        existingSchedule.setRoute(route);

        Schedules updatedSchedule = scheduleRepository.save(existingSchedule);
        return mapToDTO(updatedSchedule);
    }

    @Override
    public void deleteSchedule(Long scheduleId) {
        scheduleRepository.deleteById(scheduleId);
    }

    private SchedulesDTO mapToDTO(Schedules s) {
        Long routeId = s.getRoute() != null ? s.getRoute().getRouteId() : null;
        return new SchedulesDTO(
                s.getScheduleId(),
                routeId,
                s.getStartTime(),
                s.getEndTime()
        );
    }

    private Schedules mapToEntity(SchedulesDTO dto) {
        Schedules s = new Schedules();
        s.setStartTime(dto.getStartTime());
        s.setEndTime(dto.getEndTime());
        // route is set separately in create/update methods
        return s;
    }
}
