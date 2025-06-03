package com.tedora.TimeToGo.repository;

import com.tedora.TimeToGo.entity.Bookings;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookingRepository extends JpaRepository<Bookings, Long> {
}