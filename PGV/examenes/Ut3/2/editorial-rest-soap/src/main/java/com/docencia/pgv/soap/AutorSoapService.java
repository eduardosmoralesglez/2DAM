package com.docencia.pgv.soap;

import java.util.List;
import com.docencia.pgv.modelo.Autor;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebService;

@WebService(
    targetNamespace = "http://ies.docencia.com/autor",
    name = "AuthorPortType"
)
public interface AutorSoapService {

    @WebMethod
    List<Autor> getAllAuthors();

    @WebMethod
    Autor getAuthorById(@WebParam(name = "id") Long id);

    @WebMethod
    Autor createAuthor(@WebParam(name = "nombre") String nombre, @WebParam(name = "pais") String pais);

    @WebMethod
    void deleteAuthor(@WebParam(name = "id") Long id);
}
