package com.biblioteca.service;

import com.biblioteca.model.Prestamo;

import java.time.LocalDate;
import java.util.List;

public interface PrestamoService {
    Prestamo crearPrestamo(Long socioId, LocalDate fechaInicio);
    Prestamo devolverPrestamo(Long prestamoId);
    List<Prestamo> listarPrestamosActivosPorSocio(Long socioId);
}
