package com.loicmaria.api.controller;


import com.loicmaria.api.DTO.BookingDto;
import com.loicmaria.api.service.BookingServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;


@RestController
@RequestMapping("/bookings")
public class BookingController {

    @Autowired
    BookingServiceImpl bookingService;

    //      CRUD Operations
    //----------------------------------------------------------------------------------------------------------------

    @PostMapping
    public ResponseEntity<?> createBooking(
            @RequestParam int userId,
            @RequestParam int copyId) {

        BookingDto createdBooking = bookingService.addNewBooking(userId, copyId);

        if (createdBooking != null) {
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(createdBooking);
        } else {
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Erreur lors de la création de la réservation.");
        }
    }

    @GetMapping("/{id}")
    public BookingDto getBooking(@PathVariable int id) {
        return bookingService.get(id);
    }

    @GetMapping
    public Collection<BookingDto> getBookings() {
        return bookingService.getter();
    }

    @PutMapping("/{id}")
    public ResponseEntity<BookingDto> updateBooking(
            @PathVariable int id,
            @RequestBody BookingDto bookingDto) {

        if (id != bookingDto.getId()) {
            return ResponseEntity.badRequest().build();
        }
        bookingService.updateBooking(id, bookingDto);
        return ResponseEntity.ok(bookingDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBooking(@PathVariable int id) {
        boolean bookingExists = bookingService.exists(id);

        if (bookingExists) {
            bookingService.delete(id);
            // Renvoie un code 204 (No Content) pour indiquer le succès de la suppression.
            return ResponseEntity.noContent().build();
        } else {
            // Renvoie un code 404 (Not Found) si la réservation n'est pas trouvée.
            return ResponseEntity.notFound().build();
        }
    }


    //----------------------------------------------------------------------------------------------------------------

    // Update booking for extension
    @PutMapping("/{id}/extend")
    public BookingDto extendBooking(@PathVariable("id") int bookingId) {
        return bookingService.extendBooking(bookingId);
    }

    // Close a booking
    @PutMapping("/{id}/close")
    public BookingDto closeBooking(@PathVariable("id") int bookingId) {
        return bookingService.closeBooking(bookingId);
    }

    // Get emails of users with bookings that have ended and are not finished
    @GetMapping("/expired-emails")
    public List<String> getExpiredBookings() {
        return bookingService.listEmails();
    }

    // Get the collection of bookings for a user with a specific status
    @GetMapping("/user/{id}/status/{status}")
    public Collection<BookingDto> getBookingsByUserAndStatus(
            @PathVariable("id") int userId,
            @PathVariable("status") String status) {
        return bookingService.findByUser_IdAndStatus(userId, status);
    }
}
