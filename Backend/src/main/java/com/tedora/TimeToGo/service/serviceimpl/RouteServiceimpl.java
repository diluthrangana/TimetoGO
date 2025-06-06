package com.tedora.TimeToGo.service.serviceimpl;

import com.tedora.TimeToGo.dto.RoutesDTO;
import com.tedora.TimeToGo.entity.Cities;
import com.tedora.TimeToGo.entity.Routes;
import com.tedora.TimeToGo.repository.CitiesRepository;
import com.tedora.TimeToGo.repository.RoutesRepository;
import com.tedora.TimeToGo.service.RouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RouteServiceimpl implements RouteService {

    @Autowired
    private RoutesRepository routesRepository;

    @Autowired
    private CitiesRepository citiesRepository;

    @Override
    public List<RoutesDTO> getAllRoutes() {
        List<RoutesDTO> dtos = new ArrayList<>();
        for (Routes route : routesRepository.findAll()) {
            dtos.add(new RoutesDTO(
                    route.getRouteId(),
                    route.getRouteNo(),
                    route.getStartCity().getCityId(),
                    route.getEndCity().getCityId()
            ));
        }
        return dtos;
    }

    @Override
    public RoutesDTO getRouteByRouteNo(String routeNo) {
        Routes route = routesRepository.findByRouteNo(routeNo);
        return new RoutesDTO(
                route.getRouteId(),
                route.getRouteNo(),
                route.getStartCity().getCityId(),
                route.getEndCity().getCityId()
        );
    }

    @Override
    public List<RoutesDTO> getRoutesFromCityName(String cityName) {
        List<Routes> routes = routesRepository.findByStartCityName(cityName);
        List<RoutesDTO> dtos = new ArrayList<>();
        for (Routes route : routes) {
            dtos.add(new RoutesDTO(
                    route.getRouteId(),
                    route.getRouteNo(),
                    route.getStartCity().getCityId(),
                    route.getEndCity().getCityId()
            ));
        }
        return dtos;
    }

    @Override
    public List<String> getCityNamesInRoute(String routeNo) {
        List<Object[]> result = routesRepository.findCityNamesByRouteNo(routeNo);
        List<String> names = new ArrayList<>();
        for (Object[] obj : result) {
            names.add((String) obj[0]); // start city name
            names.add((String) obj[1]); // end city name
        }
        return names;
    }

    @Override
    public RoutesDTO saveRoute(RoutesDTO dto) {
        Cities startCity = citiesRepository.findById(dto.getStartCityId()).orElseThrow();
        Cities endCity = citiesRepository.findById(dto.getEndCityId()).orElseThrow();
        Routes route = new Routes(dto.getRouteNo(), startCity, endCity);
        Routes saved = routesRepository.save(route);
        return new RoutesDTO(saved.getRouteId(), saved.getRouteNo(), startCity.getCityId(), endCity.getCityId());
    }

    @Override
    public void deleteRoute(Long id) {
        routesRepository.deleteById(id);
    }
}
