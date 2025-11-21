package com.docencia.hotel.persistence.jpa;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

import com.docencia.hotel.domain.repository.BookingRepository;
import com.docencia.hotel.model.Booking;

public class BookingJpaRepository implements BookingRepository{

    private final IBookingJpaRepository repository;

    public BookingJpaRepository(IBookingJpaRepository repository) {
        this.repository = repository;
    }

    @Override
    public boolean exists(String id) {
        return repository.existsById(id);
    }

    @Override
    public boolean delete(String id) {
        if (!repository.existsById(id)) {
            return false;
        }
        repository.deleteById(id);
        return true;
    }

    @Override
    public Booking find(Booking example) {
        return repository.findFirstByTitle(example.getId()).orElse(null);
    }

    @Override
    public Booking findById(String id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public List<Booking> findAll() {
        return repository.findAll();
    }

    @Override
    public Booking save(Booking booking) {
        if (booking.getId() == null || booking.getId().isBlank()) {
            booking.setId(UUID.randomUUID().toString());
        }
        return repository.save(booking);
    }

    @Override
    public List<Booking> findBookingsInDates(LocalDate date1, LocalDate date2) {
        return null;
    }

    
}
