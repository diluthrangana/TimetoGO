package com.tedora.TimeToGo.controller;

import com.tedora.TimeToGo.entity.Cities;
import com.tedora.TimeToGo.service.CityService;
import com.tedora.TimeToGo.utils.EndPointUrl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class CityController {

    @Autowired
    private CityService cityService;

    @PostMapping(EndPointUrl.CITIES)
    public Cities createCity(@RequestBody Cities city) {
        return cityService.createCity(city);
    }
}
