package com.tedora.TimeToGo.service;

import com.tedora.TimeToGo.dto.BookingDTO;
import com.tedora.TimeToGo.entity.Bookings;
import java.util.List;

public interface BookingService {
    Bookings createBooking(Bookings booking);
    List<BookingDTO> getAllBookings();
    BookingDTO getBookingById(Long id);
    void deleteBooking(Long id);
    BookingDTO updateBooking(Long id, BookingDTO bookingDTO);
}