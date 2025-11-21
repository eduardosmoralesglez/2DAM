package org.formacion.procesos.repositories;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class FileRepositoryTest {

    FileRepository fileRepository;

    @BeforeEach
    void beforeEach() {
        fileRepository = new FileRepository();
        fileRepository.setFileName("fichero-test.txt");
    }

    @Test
    void addContenidoTest() {
        boolean resultado = fileRepository.add("Linea agregada");
        Assertions.assertTrue(resultado, "No se a esperado el resultado esperado");
    }

}
