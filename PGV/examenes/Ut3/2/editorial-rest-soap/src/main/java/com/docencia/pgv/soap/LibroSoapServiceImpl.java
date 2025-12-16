package com.docencia.pgv.soap;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.docencia.pgv.modelo.Libro;
import com.docencia.pgv.servicios.LibroServiceImpl;

import jakarta.jws.WebService;

@WebService(
    serviceName = "LibroService",
    portName = "LibroPort",
    targetNamespace = "http://ies.docencia.com/libro"
)
@Service
public class LibroSoapServiceImpl implements LibroSoapService {

    LibroServiceImpl libroService;

    @Autowired
    public void setLibroService(LibroServiceImpl libroService) {
        this.libroService = libroService;
    }

    @Override
    public List<Libro> getAllBooks() {
        return libroService.findAll();
    }

    @Override
    public Libro getBookById(Long id) {
        return libroService.findByIdOrThrow(id);
    }

    @Override
    public List<Libro> getBooksByAuthor(Long idAutor) {
        return null;
    }

    @Override
    public Libro createBook(String titulo, Integer anioPublicacion, Long idAutor) {
        return libroService.create(new Libro(null, titulo, anioPublicacion, idAutor));
    }

    @Override
    public void deleteBook(Long id) {
        libroService.delete(id);
    }
}
