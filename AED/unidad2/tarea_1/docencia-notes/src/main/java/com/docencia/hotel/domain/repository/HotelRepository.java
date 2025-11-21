package com.docencia.hotel.domain.repository;

import java.util.List;

import com.docencia.hotel.model.Hotel;

public interface HotelRepository extends AbstractRepository{

    Hotel find(Hotel example);

    Hotel findById(String id);

    List<Hotel> findAll();

    Hotel save(Hotel note);

    
}
