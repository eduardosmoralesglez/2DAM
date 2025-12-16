package com.docencia.pgv.soap;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.docencia.pgv.modelo.Autor;
import com.docencia.pgv.servicios.AutorServiceImpl;

import jakarta.jws.WebService;

@WebService(
    serviceName = "AutorService",
    portName = "AutorPort",
    targetNamespace = "http://ies.docencia.com/autor"
)
@Service
public class AutorSoapServiceImpl implements AutorSoapService {

    AutorServiceImpl autorService;

    @Autowired
    public void setAutorService(AutorServiceImpl autorService) {
        this.autorService = autorService;
    }

    @Override
    public List<Autor> getAllAuthors() {
        return autorService.findAll();
    }

    @Override
    public Autor getAuthorById(Long id) {
        return autorService.findByIdOrThrow(id);
    }

    @Override
    public Autor createAuthor(String nombre, String pais) {
        Autor autorACrear = new Autor(null, nombre, pais);
        return autorService.create(autorACrear);
    }

    @Override
    public void deleteAuthor(Long id) {
        autorService.delete(id);
    }
}
