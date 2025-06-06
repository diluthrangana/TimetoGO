package com.tedora.TimeToGo.repository;

import com.tedora.TimeToGo.entity.Routes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RoutesRepository extends JpaRepository<Routes, Long> {

    // Get routes starting from a particular city name
    @Query("SELECT r FROM Routes r WHERE r.startCity.cityName = :cityName")
    List<Routes> findByStartCityName(String cityName);

    // Get cities in a particular route by route number
    @Query("SELECT r.startCity.cityName, r.endCity.cityName FROM Routes r WHERE r.routeNo = :routeNo")
    List<Object[]> findCityNamesByRouteNo(String routeNo);

    // Get route by route number
    Routes findByRouteNo(String routeNo);
}
