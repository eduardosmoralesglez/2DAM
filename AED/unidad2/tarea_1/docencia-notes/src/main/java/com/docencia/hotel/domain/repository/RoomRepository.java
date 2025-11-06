package com.docencia.hotel.domain.repository;

import java.util.List;

import com.docencia.hotel.model.Hotel;
import com.docencia.hotel.model.Room;

public interface RoomRepository extends AbstractRepository{

    Room find(Room example);

    List<Room> findAll();

    Room save(Room note);

    List<Room> findRoomsByHotel(Hotel hotel);
    
}
