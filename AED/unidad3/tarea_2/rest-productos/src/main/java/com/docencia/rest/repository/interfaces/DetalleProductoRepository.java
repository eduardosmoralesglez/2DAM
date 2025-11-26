package com.docencia.rest.repository.interfaces;

import java.util.Optional;

import com.docencia.rest.modelo.DetalleProducto;

public interface DetalleProductoRepository {
    Optional<DetalleProducto> findByProductoId(Long productoId);
    DetalleProducto save(Long productoId, DetalleProducto detalle);
    void deleteByProductoId(Long productoId);
}