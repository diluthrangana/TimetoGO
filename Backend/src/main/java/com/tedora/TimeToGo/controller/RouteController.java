package com.tedora.TimeToGo.controller;

import com.tedora.TimeToGo.dto.RoutesDTO;
import com.tedora.TimeToGo.service.RouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class RouteController {

    @Autowired
    private RouteService routeService;

    @GetMapping("/routes")
    public List<RoutesDTO> getAllRoutes() {
        return routeService.getAllRoutes();
    }

    @GetMapping("/routeNo/{routeNo}")
    public RoutesDTO getRouteByRouteNo(@PathVariable String routeNo) {
        return routeService.getRouteByRouteNo(routeNo);
    }

    @GetMapping("/from-city/{cityName}")
    public List<RoutesDTO> getRoutesFromCityName(@PathVariable String cityName) {
        return routeService.getRoutesFromCityName(cityName);
    }

    @GetMapping("/cities-in-route/{routeNo}")
    public List<String> getCityNamesInRoute(@PathVariable String routeNo) {
        return routeService.getCityNamesInRoute(routeNo);
    }

    @PostMapping("/routes")
    public RoutesDTO saveRoute(@RequestBody RoutesDTO dto) {
        return routeService.saveRoute(dto);
    }

    @DeleteMapping("/{id}")
    public void deleteRoute(@PathVariable Long id) {
        routeService.deleteRoute(id);
    }
}
