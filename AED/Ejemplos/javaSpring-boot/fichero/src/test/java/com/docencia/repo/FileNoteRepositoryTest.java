package com.docencia.repo;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.docencia.files.model.Note;

public class FileNoteRepositoryTest {
    FileNoteRepository fileNoteRepository;
    Note elemento;
    Note elementoFind = null;
    String id = "00001";
    String titulo = "Mi titulo";
    String contenido = "Contenido";

    @BeforeEach
    void beforeAll() {
        fileNoteRepository = new FileNoteRepository();
        elemento = new Note(id,titulo,contenido);
        elementoFind = fileNoteRepository.findById(elemento);
        Assertions.assertNull(elementoFind, "El mensaje debe ser null");
    }

    @AfterEach
    void afterEach() {
        elementoFind = fileNoteRepository.findById(id);
        Assertions.assertNotNull(elementoFind, "El elemento no debe de ser null");
    }

    
    @Test                     
    void createFileTest() {
        Assertions.assertNotNull(fileNoteRepository, "El repositorio no debe ser nulo");
    }

    @Test                     
    void insertFileTest() {
        Note result = fileNoteRepository.findById("00001");
        Assertions.assertNotNull(result, "El resultado no puede ser nulo");
        Assertions.assertEquals(result, result, "El valor no es el esperado");
    }

}
