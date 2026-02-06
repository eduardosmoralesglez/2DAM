package com.biblioteca.service;

import com.biblioteca.model.Socio;

import java.time.LocalDate;
import java.util.List;

public interface SocioService {
    Socio crearSocio(String nombre, String email, LocalDate fechaAlta);
    Socio obtenerSocioPorId(Long id);
    List<Socio> listarSocios();
    void eliminarSocio(Long id);
}
