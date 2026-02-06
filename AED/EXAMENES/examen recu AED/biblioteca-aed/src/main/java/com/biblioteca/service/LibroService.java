package com.biblioteca.service;

import com.biblioteca.model.Libro;

import java.util.List;

public interface LibroService {
    Libro crearLibro(String isbn, String titulo, String autor, int anio);
    List<Libro> listar();
    Libro obtenerLibroPorIsbn(String isbn);
    void eliminarLibro(Long id);
}
