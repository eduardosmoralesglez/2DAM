package com.docencia.hotel.domain.repository;

import java.util.List;

import com.docencia.hotel.model.Guest;

public interface GuestRepository extends AbstractRepository{

    Guest find(Guest example);

    Guest findById(String id);

    List<Guest> findAll();

    Guest save(Guest note);

}
