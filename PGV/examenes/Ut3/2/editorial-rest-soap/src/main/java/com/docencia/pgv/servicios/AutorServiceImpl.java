package com.docencia.pgv.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.docencia.pgv.interfaces.AutorService;
import com.docencia.pgv.modelo.Autor;
import com.docencia.pgv.repositorios.InMemoryAutorRepository;

@Service
public class AutorServiceImpl implements AutorService {

    InMemoryAutorRepository autorRepository;

    @Autowired
    public void setAutorRepository(InMemoryAutorRepository autorRepository) {
        this.autorRepository = autorRepository;
    }

    @Override
    public List<Autor> findAll() {
        return autorRepository.findAll();
    }

    
    @Override
    public Autor findByIdOrThrow(Long id) {
        return autorRepository.findById(id).orElseThrow();
    }

    @Override
    public Autor create(Autor autor) {
        return autorRepository.save(autor);
    }

    @Override
    public void delete(Long id) {
        if (!autorRepository.deleteById(id)) {
            throw new IllegalArgumentException();
        }
    }
}
