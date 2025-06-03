package com.tedora.TimeToGo.controller;

import com.tedora.TimeToGo.dto.BookingDTO;
import com.tedora.TimeToGo.entity.Bookings;
import com.tedora.TimeToGo.service.BookingService;
import com.tedora.TimeToGo.utils.EndPointUrl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api")
public class BookingController {

    @Autowired
    private BookingService bookingService;

    @PostMapping(EndPointUrl.BOOKINGS)
    public ResponseEntity<Bookings> createBooking(@RequestBody Bookings booking) {
        try {
            Bookings createdBooking = bookingService.createBooking(booking);
            return ResponseEntity.status(HttpStatus.CREATED).body(createdBooking);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping(EndPointUrl.BOOKINGS)
    public ResponseEntity<List<BookingDTO>> getAllBookings() {
        try {
            List<BookingDTO> bookings = bookingService.getAllBookings();
            return ResponseEntity.ok(bookings);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping(EndPointUrl.BOOKINGS + "/{id}")
    public ResponseEntity<BookingDTO> getBookingById(@PathVariable Long id) {
        try {
            BookingDTO booking = bookingService.getBookingById(id);
            if (booking != null) {
                return ResponseEntity.ok(booking);
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @DeleteMapping(EndPointUrl.BOOKINGS + "/{id}")
    public ResponseEntity<Void> deleteBooking(@PathVariable Long id) {
        try {
            bookingService.deleteBooking(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PutMapping(EndPointUrl.BOOKINGS + "/{id}")
    public ResponseEntity<BookingDTO> updateBooking(@PathVariable Long id, @RequestBody BookingDTO bookingDTO) {
        try {
            BookingDTO updatedBooking = bookingService.updateBooking(id, bookingDTO);
            if (updatedBooking != null) {
                return ResponseEntity.ok(updatedBooking);
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}