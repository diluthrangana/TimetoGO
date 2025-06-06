package com.tedora.TimeToGo.service;

import com.tedora.TimeToGo.dto.RoutesDTO;

import java.util.List;

public interface RouteService {
    List<RoutesDTO> getAllRoutes();
    RoutesDTO getRouteByRouteNo(String routeNo);
    List<RoutesDTO> getRoutesFromCityName(String cityName);
    List<String> getCityNamesInRoute(String routeNo);
    RoutesDTO saveRoute(RoutesDTO dto);
    void deleteRoute(Long id);
}
