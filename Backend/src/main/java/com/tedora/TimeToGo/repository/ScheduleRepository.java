package com.tedora.TimeToGo.repository;

import com.tedora.TimeToGo.entity.Schedules;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ScheduleRepository extends JpaRepository<Schedules, Long> {

    List<Schedules> findByRouteRouteId(Long routeId);

    List<Schedules> findByBusContactBusId(String busId);

    List<Schedules> findByStartTime(String startTime);

    @Query("SELECT s FROM Schedules s WHERE s.startTime = :startTime AND s.route.routeId = :routeId")
    List<Schedules> findByStartTimeAndRouteId(String startTime, Long routeId);

    @Query("SELECT s FROM Schedules s WHERE s.startTime = :startTime AND s.route.startCity.cityName = :startCity")
    List<Schedules> findByStartTimeAndStartCity(String startTime, String startCity);
}
