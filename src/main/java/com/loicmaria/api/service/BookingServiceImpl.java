package com.loicmaria.api.service;

import com.loicmaria.api.DTO.BookingDto;
import com.loicmaria.api.model.Booking;
import com.loicmaria.api.repository.BookingRepository;
import org.springframework.stereotype.Service;

import java.util.Collection;


@Service
public class BookingServiceImpl extends Services<Booking, BookingDto, BookingRepository> {

    @Override
    public Booking convertDtoToEntity(BookingDto bookingDto) {
        Booking booking = modelMapper.map(bookingDto, Booking.class);
        return booking;
    }

    @Override
    public BookingDto convertEntityToDto(Booking booking) {
        BookingDto bookingDto = modelMapper.map(booking,  BookingDto.class);
        return bookingDto;
    }

    public Collection<BookingDto> findByUserIdAndStatus(int id, String status){
        Collection<Booking> bookingCollection = repository.findByUser_IdAndStatus(id, status);
        Collection<BookingDto> bookingDtoCollection =  convertCollectionToDto(bookingCollection);
        return bookingDtoCollection;
    }
}
