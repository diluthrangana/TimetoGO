package com.tedora.TimeToGo.controller;

import com.tedora.TimeToGo.dto.BusesDTO;
import com.tedora.TimeToGo.entity.Buses;
import com.tedora.TimeToGo.service.BusService;
import com.tedora.TimeToGo.utils.EndPointUrl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api")
public class BusController {

    @Autowired
    private BusService busService;

    @PostMapping(EndPointUrl.BUSES)
    public ResponseEntity<Buses> createBus(@RequestBody Buses bus) {
        try {
            Buses createdBus = busService.createBus(bus);
            return ResponseEntity.status(HttpStatus.CREATED).body(createdBus);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping(EndPointUrl.BUSES)
    public ResponseEntity<List<BusesDTO>> getAllBuses() {
        try {
            List<BusesDTO> buses = busService.getAllBuses();
            return ResponseEntity.ok(buses);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping(EndPointUrl.BUSES + "/{id}")
    public ResponseEntity<BusesDTO> getBusById(@PathVariable Long id) {
        try {
            BusesDTO bus = busService.getBusById(id);
            if (bus != null) {
                return ResponseEntity.ok(bus);
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @DeleteMapping(EndPointUrl.BUSES + "/{id}")
    public ResponseEntity<Void> deleteBus(@PathVariable Long id) {
        try {
            busService.deleteBus(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PutMapping(EndPointUrl.BUSES + "/{id}")
    public ResponseEntity<BusesDTO> updateBus(@PathVariable Long id, @RequestBody BusesDTO busesDTO) {
        try {
            BusesDTO updatedBus = busService.updateBus(id, busesDTO);
            if (updatedBus != null) {
                return ResponseEntity.ok(updatedBus);
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
