package com.tedora.TimeToGo.service;

import com.tedora.TimeToGo.dto.BusesDTO;
import com.tedora.TimeToGo.entity.Buses;

import java.util.List;

public interface BusService {
    Buses createBus(Buses bus);
    List<BusesDTO> getAllBuses();
    BusesDTO getBusById(Long id);
    BusesDTO updateBus(Long id, BusesDTO busesDTO);
    void deleteBus(Long id);
}
