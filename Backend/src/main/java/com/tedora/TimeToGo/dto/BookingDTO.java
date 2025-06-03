package com.tedora.TimeToGo.dto;

import com.tedora.TimeToGo.enums.BookingStatus;

import java.time.LocalDateTime;

public class BookingDTO {

    private Long bookingId;
    private String userId;
    private String scheduleId;
    private String seatNumber;
    private LocalDateTime bookingTime;
    private BookingStatus bookingStatus;
    private String passengerName;
    private String contactNumber;

    public BookingDTO() {}

    public BookingDTO(Long bookingId, String userId, String scheduleId, String seatNumber,
                      LocalDateTime bookingTime, BookingStatus bookingStatus,
                      String passengerName, String contactNumber) {
        this.bookingId = bookingId;
        this.userId = userId;
        this.scheduleId = scheduleId;
        this.seatNumber = seatNumber;
        this.bookingTime = bookingTime;
        this.bookingStatus = bookingStatus;
        this.passengerName = passengerName;
        this.contactNumber = contactNumber;
    }

    // Getters and Setters

    public Long getBookingId() { return bookingId; }
    public void setBookingId(Long bookingId) { this.bookingId = bookingId; }

    public String getUserId() { return userId; }
    public void setUserId(String userId) { this.userId = userId; }

    public String getScheduleId() { return scheduleId; }
    public void setScheduleId(String scheduleId) { this.scheduleId = scheduleId; }

    public String getSeatNumber() { return seatNumber; }
    public void setSeatNumber(String seatNumber) { this.seatNumber = seatNumber; }

    public LocalDateTime getBookingTime() { return bookingTime; }
    public void setBookingTime(LocalDateTime bookingTime) { this.bookingTime = bookingTime; }

    public BookingStatus getBookingStatus() { return bookingStatus; }
    public void setBookingStatus(BookingStatus bookingStatus) { this.bookingStatus = bookingStatus; }

    public String getPassengerName() { return passengerName; }
    public void setPassengerName(String passengerName) { this.passengerName = passengerName; }

    public String getContactNumber() { return contactNumber; }
    public void setContactNumber(String contactNumber) { this.contactNumber = contactNumber; }
}
