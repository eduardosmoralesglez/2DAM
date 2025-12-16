package com.docencia.pgv.soap;

import java.util.List;
import com.docencia.pgv.modelo.Libro;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebService;

@WebService(targetNamespace = "http://ies.docencia.com/libro", name = "LibroPortType")
public interface LibroSoapService {

    @WebMethod
    List<Libro> getAllBooks();

    @WebMethod
    Libro getBookById(@WebParam(name = "id") Long id);

    @WebMethod
    List<Libro> getBooksByAuthor(@WebParam(name = "idAutor") Long idAutor);

    @WebMethod
    Libro createBook(@WebParam(name = "titulo") String titulo,
            @WebParam(name = "anioPublicacion") Integer anioPublicacion,
            @WebParam(name = "idAutor") Long idAutor);

    @WebMethod
    void deleteBook(@WebParam(name = "id") Long id);
}
