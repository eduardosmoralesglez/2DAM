package com.docencia.hotel.persistence.jpa;

import java.util.List;
import java.util.UUID;

import com.docencia.hotel.domain.repository.GuestRepository;
import com.docencia.hotel.model.Guest;

public class GuestJpaRepository implements GuestRepository{

    private final IGuestJpaRepository repository;

    public GuestJpaRepository(IGuestJpaRepository repository) {
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
    public Guest find(Guest example) {
        return repository.findFirstByTitle(example.getName()).orElse(null);
    }

    @Override
    public Guest findById(String id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public List<Guest> findAll() {
        return repository.findAll();
    }

    @Override
    public Guest save(Guest guest) {
        if (guest.getId() == null || guest.getId().isBlank()) {
            guest.setId(UUID.randomUUID().toString());
        }
        return repository.save(guest);
    }


}
