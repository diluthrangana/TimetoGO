package com.tedora.TimeToGo.repository;

import com.tedora.TimeToGo.entity.Bookings;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookingRepository extends JpaRepository<Bookings, Long> {

    @Query("SELECT b.passengerName FROM Bookings b WHERE b.schedule.scheduleId = :scheduleId")
    List<String> findPassengerNamesByScheduleId(Long scheduleId);

}