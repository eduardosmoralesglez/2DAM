package com.biblioteca.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.biblioteca.model.Prestamo;

public interface PrestamoRepository extends JpaRepository<Prestamo, Long>{

}