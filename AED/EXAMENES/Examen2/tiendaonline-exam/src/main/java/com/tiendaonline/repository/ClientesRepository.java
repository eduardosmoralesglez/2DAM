package com.tiendaonline.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tiendaonline.model.Cliente;

@Repository
public interface ClientesRepository extends JpaRepository<Cliente, Integer>{
    public List<Cliente> findAllSortedByNombre();
}
