package com.docencia.rest.services.interfaces;

import java.util.List;
import java.util.Optional;

import com.docencia.rest.domain.Producto;

public interface ProductoServiceInterface {
    Optional<Producto> findById(int id);
    Optional<Producto> find(Producto producto);
    List<Producto> findAll();
    Producto save(Producto producto);
    boolean deleteById(int id);
    boolean delete(Producto producto);
}