package com.tedora.TimeToGo.service.serviceimpl;

import com.tedora.TimeToGo.dto.BusesDTO;
import com.tedora.TimeToGo.entity.Buses;
import com.tedora.TimeToGo.repository.BusesRepository;
import com.tedora.TimeToGo.service.BusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BusServiceimpl implements BusService {

    @Autowired
    private BusesRepository busesRepository;

    @Override
    public Buses createBus(Buses bus) {
        return busesRepository.save(bus);
    }

    @Override
    public List<BusesDTO> getAllBuses() {
        List<Buses> buses = busesRepository.findAll();
        return buses.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public BusesDTO getBusById(Long id) {
        Optional<Buses> bus = busesRepository.findById(id);
        return bus.map(this::convertToDTO).orElse(null);
    }

    @Override
    public BusesDTO updateBus(Long id, BusesDTO busesDTO) {
        Optional<Buses> existingBusOpt = busesRepository.findById(id);
        if (existingBusOpt.isEmpty()) {
            return null;
        }

        Buses existingBus = existingBusOpt.get();
        existingBus.setBusNumber(busesDTO.getBusNumber());
        existingBus.setCapacity(busesDTO.getCapacity());
        existingBus.setOwnership(busesDTO.getOwnership());
        existingBus.setBusClass(busesDTO.getBusClass());
        existingBus.setBusType(busesDTO.getBusType());
        existingBus.setManufacturer(busesDTO.getManufacturer());

        Buses updatedBus = busesRepository.save(existingBus);
        return convertToDTO(updatedBus);
    }

    @Override
    public void deleteBus(Long id) {
        busesRepository.deleteById(id);
    }

    // Helper method to convert from entity to DTO
    private BusesDTO convertToDTO(Buses bus) {
        return new BusesDTO(
                bus.getBusId(),
                bus.getBusNumber(),
                bus.getCapacity(),
                bus.getOwnership(),
                bus.getBusClass(),
                bus.getBusType(),
                bus.getManufacturer()
        );
    }
}
