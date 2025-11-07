package com.docencia.hotel.persistence.jpa;

import java.util.List;
import java.util.UUID;

import com.docencia.hotel.domain.repository.RoomRepository;
import com.docencia.hotel.model.Hotel;
import com.docencia.hotel.model.Room;

public class RoomJpaRepository implements RoomRepository{

    private final IRoomJpaRepository repository;

    public RoomJpaRepository(IRoomJpaRepository repository) {
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
    public Room find(Room example) {
        return repository.findFirstByTitle(example.getNumber()).orElse(null);
    }

    @Override
    public Room findById(String id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public List<Room> findAll() {
        return repository.findAll();
    }

    @Override
    public Room save(Room room) {
        if (room.getId() == null || room.getId().isBlank()) {
            room.setId(UUID.randomUUID().toString());
        }
        return repository.save(room);
    }

    @Override
    public List<Room> findRoomsByHotel(Hotel hotel) {
        
    }

   
}
