package com.biblioteca.service;

import com.biblioteca.model.mongo.SocioDetalles;

import java.util.Optional;

public interface SocioDetallesService {
    Optional<SocioDetalles> obtenerDetallesPorSocioId(Long socioId);
}
