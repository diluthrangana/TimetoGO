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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userId", referencedColumnName = "userId")
    private Users user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "scheduleId", referencedColumnName = "scheduleId")
    private Schedules schedule;

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

    public Bookings(Long bookingId, Users user, Schedules schedule, String seatNumber,
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

    @PrePersist
    protected void onCreate() {
        if (bookingTime == null) {
            bookingTime = LocalDateTime.now();
        }
    }

    // Getters and Setters
    public Long getBookingId() { return bookingId; }
    public void setBookingId(Long bookingId) { this.bookingId = bookingId; }

    public Users getUser() { return user; }
    public void setUser(Users user) { this.user = user; }

    public Schedules getSchedule() { return schedule; }
    public void setSchedule(Schedules schedule) { this.schedule = schedule; }

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
