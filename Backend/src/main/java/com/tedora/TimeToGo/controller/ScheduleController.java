package com.tedora.TimeToGo.controller;

import com.tedora.TimeToGo.dto.SchedulesDTO;
import com.tedora.TimeToGo.service.ScheduleService;
import com.tedora.TimeToGo.utils.EndPointUrl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ScheduleController {

    @Autowired
    private ScheduleService scheduleService;

    @GetMapping(EndPointUrl.SCHEDULE)
    public ResponseEntity<List<SchedulesDTO>> getAllSchedules() {
        List<SchedulesDTO> schedules = scheduleService.getAllSchedules();
        return ResponseEntity.ok(schedules);
    }

    @GetMapping(EndPointUrl.SCHEDULE + "/{id}")
    public ResponseEntity<SchedulesDTO> getScheduleById(@PathVariable("id") Long id) {
        SchedulesDTO schedule = scheduleService.getScheduleByScheduleId(id);
        return ResponseEntity.ok(schedule);
    }

    @PostMapping(EndPointUrl.SCHEDULE)
    public ResponseEntity<SchedulesDTO> createSchedule(@RequestBody SchedulesDTO dto) {
        SchedulesDTO createdSchedule = scheduleService.createSchedule(dto);
        return ResponseEntity.ok(createdSchedule);
    }

    @PutMapping(EndPointUrl.SCHEDULE + "/{id}")//not worrking**************************
    public ResponseEntity<SchedulesDTO> updateSchedule(@PathVariable("id") Long id, @RequestBody SchedulesDTO dto) {
        SchedulesDTO updatedSchedule = scheduleService.updateSchedule(id, dto);
        return ResponseEntity.ok(updatedSchedule);
    }

    @DeleteMapping(EndPointUrl.SCHEDULE + "/{id}")
    public ResponseEntity<Void> deleteSchedule(@PathVariable("id") Long id) {
        scheduleService.deleteSchedule(id);
        return ResponseEntity.noContent().build();
    }
}
