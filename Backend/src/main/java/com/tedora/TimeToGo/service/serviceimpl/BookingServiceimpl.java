package com.tedora.TimeToGo.service.serviceimpl;

import com.tedora.TimeToGo.dto.BookingDTO;
import com.tedora.TimeToGo.entity.Bookings;
import com.tedora.TimeToGo.repository.BookingRepository;
import com.tedora.TimeToGo.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BookingServiceimpl implements BookingService {

    @Autowired
    private BookingRepository bookingRepository;

    @Override
    public Bookings createBooking(Bookings booking) {
        return bookingRepository.save(booking);
    }

    @Override
    public List<BookingDTO> getAllBookings() {
        List<Bookings> bookings = bookingRepository.findAll();
        return bookings.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public BookingDTO getBookingById(Long id) {
        Optional<Bookings> booking = bookingRepository.findById(id);
        return booking.map(this::convertToDTO).orElse(null);
    }

    @Override
    public void deleteBooking(Long id) {
        bookingRepository.deleteById(id);
    }

    @Override
    public BookingDTO updateBooking(Long id, BookingDTO bookingDTO) {
        Optional<Bookings> existingBookingOpt = bookingRepository.findById(id);

        if (existingBookingOpt.isPresent()) {
            Bookings existingBooking = existingBookingOpt.get();

            // Update fields
            existingBooking.setUserId(bookingDTO.getUserId());
            existingBooking.setScheduleId(bookingDTO.getScheduleId());
            existingBooking.setSeatNumber(bookingDTO.getSeatNumber());
            existingBooking.setBookingStatus(bookingDTO.getBookingStatus());
            existingBooking.setPassengerName(bookingDTO.getPassengerName());
            existingBooking.setContactNumber(bookingDTO.getContactNumber());

            // Don't update bookingTime as it should remain the original booking time

            Bookings updatedBooking = bookingRepository.save(existingBooking);
            return convertToDTO(updatedBooking);
        }

        return null;
    }

    // Helper method to convert Entity to DTO
    private BookingDTO convertToDTO(Bookings booking) {
        BookingDTO dto = new BookingDTO();
        dto.setBookingId(booking.getBookingId());
        dto.setUserId(booking.getUserId());
        dto.setScheduleId(booking.getScheduleId());
        dto.setSeatNumber(booking.getSeatNumber());
        dto.setBookingTime(booking.getBookingTime());
        dto.setBookingStatus(booking.getBookingStatus());
        dto.setPassengerName(booking.getPassengerName());
        dto.setContactNumber(booking.getContactNumber());
        return dto;
    }
}