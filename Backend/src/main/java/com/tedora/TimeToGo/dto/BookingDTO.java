package com.tedora.TimeToGo.dto;

import com.tedora.TimeToGo.entity.Schedules;
import com.tedora.TimeToGo.entity.Users;
import com.tedora.TimeToGo.enums.BookingStatus;

import java.time.LocalDateTime;

public class BookingDTO {

    private Long bookingId;
    private Users user;
    private Schedules schedule;
    private String seatNumber;
    private LocalDateTime bookingTime;
    private BookingStatus bookingStatus;
    private String passengerName;
    private String contactNumber;

    public BookingDTO() {}

    public BookingDTO(Long bookingId, Users user, Schedules schedule, String seatNumber,
                      LocalDateTime bookingTime, BookingStatus bookingStatus,
                      String passengerName, String contactNumber) {
        this.bookingId = bookingId;
        this.user = user;
        this.schedule = schedule;
        this.seatNumber = seatNumber;
        this.bookingTime = bookingTime;
        this.bookingStatus = bookingStatus;
        this.passengerName = passengerName;
        this.contactNumber = contactNumber;
    }

    public Long getBookingId() {
        return bookingId;
    }

    public void setBookingId(Long bookingId) {
        this.bookingId = bookingId;
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }

    public Schedules getSchedule() {
        return schedule;
    }

    public void setSchedule(Schedules schedule) {
        this.schedule = schedule;
    }

    public String getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(String seatNumber) {
        this.seatNumber = seatNumber;
    }

    public LocalDateTime getBookingTime() {
        return bookingTime;
    }

    public void setBookingTime(LocalDateTime bookingTime) {
        this.bookingTime = bookingTime;
    }

    public BookingStatus getBookingStatus() {
        return bookingStatus;
    }

    public void setBookingStatus(BookingStatus bookingStatus) {
        this.bookingStatus = bookingStatus;
    }

    public String getPassengerName() {
        return passengerName;
    }

    public void setPassengerName(String passengerName) {
        this.passengerName = passengerName;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }
}
