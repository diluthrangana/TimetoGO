package com.tedora.TimeToGo.controller;

import com.tedora.TimeToGo.entity.Cities;
import com.tedora.TimeToGo.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api") // This maps requests to /api/cities
public class CityController {

    @Autowired
    private CityService cityService;

    @PostMapping("/cities")
    public Cities createCity(@RequestBody Cities city) {
        return cityService.createCity(city);
    }
}
