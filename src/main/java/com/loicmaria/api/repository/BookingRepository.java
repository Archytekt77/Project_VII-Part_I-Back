package com.loicmaria.api.repository;

import com.loicmaria.api.model.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;


@Repository
public interface BookingRepository extends JpaRepository<Booking, Integer> {
    Collection<Booking> findByUser_IdAndStatus(int id, String status);
}
