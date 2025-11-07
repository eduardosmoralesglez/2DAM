package com.docencia.hotel.domain.repository;

import java.time.LocalDate;
import java.util.List;

import com.docencia.hotel.model.Booking;


public interface BookingRepository extends AbstractRepository{

    Booking find(Booking example);

    Booking findById(String id);

    List<Booking> findAll();

    Booking save(Booking note);

    List<Booking> findBookingsInDates(LocalDate date1, LocalDate date2);

}
