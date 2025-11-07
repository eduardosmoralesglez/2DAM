package com.docencia.hotel.persistence.jpa;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.docencia.hotel.model.Room;

public interface IRoomJpaRepository extends JpaRepository<Room, String>{

    Optional<Room> findFirstByTitle(String title);
}
