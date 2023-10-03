package com.loicmaria.api.controller;


import com.loicmaria.api.DTO.BookingDto;
import com.loicmaria.api.model.Booking;
import com.loicmaria.api.service.BookingServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;


@RestController
@RequestMapping("/bookings")
public class BookingController {

    @Autowired
    BookingServiceImpl bookingService;

    //      CRUD
    //----------------------------------------------------------------------------------------------------------------

    /**
     * Create - Add a new booking
     *
     * @param userId The id of the user to add.
     * @param copyId The id of the copy to add.
     * @return ResponseEntity.ok
     */
    @PostMapping("/create/{userId}/{copyId}")
    public ResponseEntity<?> createBooking(@PathVariable int userId, @PathVariable int copyId) {
        return ResponseEntity.ok(bookingService.addNewBooking(userId, copyId));
    }

    /**
     * Read - Get one booking
     *
     * @param id The id of the booking
     * @return An Booking object full filled
     */
    @GetMapping("/id/{id}")
    public BookingDto getBooking(@PathVariable("id") int id) {
        return bookingService.get(id);
    }

    /**
     * Read - Get all bookings
     *
     * @return - An Iterable object of Booking full filled
     */
    @GetMapping("/all")
    public Collection<BookingDto> getBookings() {
        return bookingService.getter();
    }

    /**
     * Update - Update an existing booking
     *
     * @param bookingDto - The booking object updated
     * @return The currentBooking if he is present or null
     */
    @PutMapping("/update")
    public BookingDto updateBooking(@RequestBody BookingDto bookingDto) {
        bookingService.save(bookingDto);
        return bookingDto;
    }

    /**
     * Delete - Delete an booking
     *
     * @param id - The id of the booking to delete
     */
    @DeleteMapping("/id/{id}")
    public void deleteBooking(@PathVariable("id") int id) {
        bookingService.delete(id);
    }

    //----------------------------------------------------------------------------------------------------------------

    /**
     * Update - booking extension update
     *
     * @param bookingId - The id of booking object updated
     * @return The currentBooking if he is present or null
     */
    @PutMapping("/extend/{id}")
    public BookingDto extendBooking(@PathVariable("id") int bookingId) {
        BookingDto bookingDto = bookingService.extendBooking(bookingId);
        return bookingDto;
    }

    /**
     * Update - Closing booking
     *
     * @param bookingId - The id of the booking object updated
     * @return The currentBooking if he is present or null
     */
    @PutMapping("/close/{id}")
    public BookingDto closeBooking(@PathVariable("id") int bookingId) {
        BookingDto bookingDto = bookingService.closeBooking(bookingId);
        return bookingDto;
    }


    /**
     * Read - Get the collection of booking's user with the status.
     *
     * @param id     The id of the user.
     * @param status The status of the booking.
     * @return The collection of booking's user.
     */
    @GetMapping("/by_user_id/{id}")
    public Collection<BookingDto> getBookingsByUser_IdAndStatus(@PathVariable("id") int id, String status) {
        System.out.println("ICI : " + id + ", " + status);
        return bookingService.findByUser_IdAndStatus(id, status);
    }


}
