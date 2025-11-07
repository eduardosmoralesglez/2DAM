package com.docencia.hotel.persistence.jpa;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.docencia.hotel.model.Booking;

public interface IBookingJpaRepository extends JpaRepository<Booking, String>{

    Optional<Booking> findFirstByTitle(String title);
}
