package com.loicmaria.api.repository;

import com.loicmaria.api.model.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Collection;
import java.util.List;


@Repository
public interface BookingRepository extends JpaRepository<Booking, Integer> {
    Collection<Booking> findByUser_IdAndStatus(int id, String status);
    List<Booking> findAllByEndDateBeforeAndStatusIsNot(LocalDate date, String status);
}
