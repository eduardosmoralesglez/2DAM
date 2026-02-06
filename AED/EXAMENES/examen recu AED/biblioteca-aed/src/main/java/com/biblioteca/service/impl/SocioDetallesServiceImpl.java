package com.biblioteca.service.impl;

import com.biblioteca.model.mongo.SocioDetalles;
import com.biblioteca.service.SocioDetallesService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SocioDetallesServiceImpl implements SocioDetallesService {

    @Override
    public Optional<SocioDetalles> obtenerDetallesPorSocioId(Long socioId) {
        throw new UnsupportedOperationException("TODO");
    }
}
