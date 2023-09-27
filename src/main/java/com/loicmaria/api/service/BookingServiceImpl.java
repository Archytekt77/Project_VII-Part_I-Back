package com.loicmaria.api.service;

import com.loicmaria.api.DTO.BookingDto;
import com.loicmaria.api.model.Booking;
import com.loicmaria.api.model.Copy;
import com.loicmaria.api.model.User;
import com.loicmaria.api.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Collection;

@Service
public class BookingServiceImpl extends Services<Booking, BookingDto, BookingRepository> {

    @Autowired
    UserServiceImpl userService;
    @Autowired
    CopyServiceImpl copyService;

    @Override
    public Booking convertDtoToEntity(BookingDto bookingDto) {
        Booking booking = modelMapper.map(bookingDto, Booking.class);
        return booking;
    }

    @Override
    public BookingDto convertEntityToDto(Booking booking) {
        BookingDto bookingDto = modelMapper.map(booking, BookingDto.class);
        return bookingDto;
    }


    public BookingDto addNewBooking(int userId, int copyId) {
        Booking booking = new Booking();
        User user = userService.convertDtoToEntity(userService.get(userId));
        Copy copy = copyService.convertDtoToEntity(copyService.get(copyId));

        copy.setCopies(copy.getCopies() - 1);

        copyService.save(copyService.convertEntityToDto(copy));

        booking.setStatus("in progress");
        booking.setExtraTime(false);
        booking.setStartDate(LocalDate.now());
        booking.setEndDate(LocalDate.now().plusWeeks(4));
        booking.setUser(user);
        booking.setCopy(copy);

        this.repository.save(booking);

        return this.convertEntityToDto(booking);
    }

    public BookingDto extendBooking(BookingDto bookingDto) {
        Booking booking = this.convertDtoToEntity(bookingDto);
        booking.setStatus("extend");
        booking.setExtraTime(true);
        booking.setEndDate(booking.getEndDate().plusWeeks(4));

        this.repository.save(booking);

        return this.convertEntityToDto(booking);
    }

    public BookingDto closeBooking(BookingDto bookingDto) {
        Booking booking = this.convertDtoToEntity(bookingDto);
        Copy copy = booking.getCopy();

        copy.setCopies(copy.getCopies() + 1);

        copyService.save(copyService.convertEntityToDto(copy));

        booking.setStatus("finish");

        this.repository.save(booking);

        return this.convertEntityToDto(booking);
    }


    public Collection<BookingDto> findByUserIdAndStatus(int id, String status) {
        Collection<Booking> bookingCollection = repository.findByUser_IdAndStatus(id, status);
        Collection<BookingDto> bookingDtoCollection = convertCollectionToDto(bookingCollection);
        return bookingDtoCollection;
    }
}
