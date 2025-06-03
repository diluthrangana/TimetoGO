package com.tedora.TimeToGo.entity;

import com.tedora.TimeToGo.enums.BookingStatus;
import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "booking")
public class Bookings {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "bookingId")
    private Long bookingId;

    @Column(name = "userId", nullable = false)
    private String userId;

    @Column(name = "scheduleId", nullable = false)
    private String scheduleId;

    @Column(name = "seatNumber", nullable = false)
    private String seatNumber;

    @Column(name = "bookingTime", nullable = false)
    private LocalDateTime bookingTime;

    @Column(name = "bookingStatus")
    @Enumerated(EnumType.STRING)
    private BookingStatus bookingStatus = BookingStatus.CONFIRMED;

    @Column(name = "passengerName")
    private String passengerName;

    @Column(name = "contactNumber")
    private String contactNumber;

    public Bookings() {
    }

    public Bookings(Long bookingId, String userId, String scheduleId, String seatNumber,
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

    @PrePersist
    protected void onCreate() {
        if (bookingTime == null) {
            bookingTime = LocalDateTime.now();
        }
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
