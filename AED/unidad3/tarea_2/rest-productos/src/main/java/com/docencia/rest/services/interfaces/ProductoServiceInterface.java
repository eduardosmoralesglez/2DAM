package com.docencia.rest.services.interfaces;

import java.util.List;
import java.util.Optional;

import com.docencia.rest.modelo.ProductoEntity;

public interface ProductoServiceInterface {
    Optional<ProductoEntity> findById(int id);
    Optional<ProductoEntity> find(ProductoEntity producto);
    List<ProductoEntity> findAll();
    ProductoEntity save(ProductoEntity producto);
    boolean deleteById(int id);
    boolean delete(ProductoEntity producto);
}