package com.docencia.hotel.persistence.jpa;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.docencia.hotel.model.Guest;

public interface IGuestJpaRepository extends JpaRepository<Guest, String>{

    Optional<Guest> findFirstByTitle(String title);

}
