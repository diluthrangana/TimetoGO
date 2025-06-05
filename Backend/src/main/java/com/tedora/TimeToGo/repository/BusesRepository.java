package com.tedora.TimeToGo.repository;

import com.tedora.TimeToGo.entity.Buses;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BusesRepository extends JpaRepository<Buses, Long> {
}