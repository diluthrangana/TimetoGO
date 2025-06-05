package com.tedora.TimeToGo.service.serviceimpl;

import com.tedora.TimeToGo.entity.Cities;
import com.tedora.TimeToGo.repository.CitiesRepository;
import com.tedora.TimeToGo.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CityServiceimpl implements CityService {

    @Autowired
    private CitiesRepository citiesRepository;

    @Override
    public Cities createCity(Cities cities) {
        return citiesRepository.save(cities);
    }
}
