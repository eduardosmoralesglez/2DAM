package com.biblioteca.service.impl;

import com.biblioteca.model.Socio;
import com.biblioteca.repository.SocioRepository;
import com.biblioteca.service.SocioService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class SocioServiceImpl implements SocioService {

    private SocioRepository repository;

    public SocioServiceImpl(SocioRepository repository) {
        this.repository = repository;
    }

    @Override
    public Socio crearSocio(String nombre, String email, LocalDate fechaAlta) {
        Socio crear = new Socio(null, nombre, email, LocalDate.now());
        return repository.save(crear);
    }

    @Override
    public Socio obtenerSocioPorId(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public List<Socio> listarSocios() {
        return repository.findAll();
    }

    @Override
    public void eliminarSocio(Long id) {
        repository.deleteById(id);
    }
}
