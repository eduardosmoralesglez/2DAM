package com.docencia.pgv.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.docencia.pgv.interfaces.LibroService;
import com.docencia.pgv.modelo.Libro;
import com.docencia.pgv.repositorios.InMemoryLibroRepository;

@Service
public class LibroServiceImpl implements LibroService {

    InMemoryLibroRepository libroRepository;

    @Autowired
    public void setLibroRepository(InMemoryLibroRepository libroRepository) {
        this.libroRepository = libroRepository;
    }

    @Override
    public List<Libro> findAll() {
        return libroRepository.findAll();
    }

    @Override
    public Libro findByIdOrThrow(Long id) {
        return libroRepository.findById(id).orElse(null);
    }

    @Override
    public List<Libro> findByAutorOrThrow(Long idAutor) {
        return libroRepository.findByIdAutor(idAutor);
    }

    @Override
    public Libro create(Libro libro) {
        return libroRepository.save(libro);
    }

    @Override
    public void delete(Long id) {
        if (!libroRepository.deleteById(id)) {
            throw new IllegalArgumentException();
        }
    }
}
