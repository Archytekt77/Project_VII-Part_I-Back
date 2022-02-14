package com.loicmaria.api.controller;

import com.loicmaria.api.DTO.BookingDto;
import com.loicmaria.api.service.BookingServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/bookings")
public class BookingController {

    @Autowired
    BookingServiceImpl bookingService;

    @PostMapping
    public BookingDto createBooking(@RequestBody BookingDto bookingDto){
        return bookingService.save(bookingDto);
    }

    @GetMapping("/{id}")
    public BookingDto getBooking(@PathVariable("id") int id){
    BookingDto bookingDto = bookingService.get(id);
    return bookingDto;
    }

    @GetMapping
    public Collection<BookingDto> getBookings(){
        return bookingService.getter();
    }

    @PutMapping("/{id}")
    public BookingDto updateBooking(@PathVariable("id") int id, @RequestBody BookingDto bookingDto){
        bookingService.save(bookingDto);
        return bookingDto;
    }

    @DeleteMapping("/{id}")
    public void deleteBooking(@PathVariable("id") int id){
        bookingService.delete(id);
    }

    @GetMapping("/{id}/{status}")
    public Collection<BookingDto> getBookingByUserIdAndStatus(@PathVariable("id") int id, @PathVariable("status") String status){
        return bookingService.findByUserIdAndStatus(id, status);
    }



}
