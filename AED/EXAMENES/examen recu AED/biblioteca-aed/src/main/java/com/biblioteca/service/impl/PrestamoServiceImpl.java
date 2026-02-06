package com.biblioteca.service.impl;

import com.biblioteca.model.Prestamo;
import com.biblioteca.model.PrestamoEstado;
import com.biblioteca.model.Socio;
import com.biblioteca.repository.PrestamoRepository;
import com.biblioteca.repository.SocioRepository;
import com.biblioteca.service.PrestamoService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class PrestamoServiceImpl implements PrestamoService {

    private PrestamoRepository repository;

    private SocioRepository socioRepository;

    public PrestamoServiceImpl(PrestamoRepository repository, SocioRepository socioRepository) {
        this.repository = repository;
        this.socioRepository = socioRepository;
    }

    @Override
    public Prestamo crearPrestamo(Long socioId, LocalDate fechaInicio) {
        Socio socio = socioRepository.findById(socioId).orElse(null);
        if (socio == null) {
            throw new Error("El Id de socio no existe");
        }
        Prestamo save = new Prestamo(null, socio, fechaInicio, null, PrestamoEstado.ACTIVO);
        return repository.save(save);
    }

    @Override
    public Prestamo devolverPrestamo(Long prestamoId) {
        Prestamo devolver = repository.findById(prestamoId).orElse(null);
        devolver.setFechaFin(LocalDate.now());
        devolver.setEstado(PrestamoEstado.DEVUELTO);
        return repository.save(devolver);
    }

    @Override
    public List<Prestamo> listarPrestamosActivosPorSocio(Long socioId) {
        List<Prestamo> prestamos = repository.findAll();
        return null;

    }


}
