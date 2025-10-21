package org.formacion.procesos.services;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ComandosLsServiceTest {

    ComandoLsService comandoLsService;
    String[] arrayComando;

    @BeforeEach
    void beforeEach() {
        comandoLsService = new ComandoLsService();
        comandoLsService.setComando("ls");
    }

    @Test
    void validarTest() {
        String[] arrayComando = {"ls","-la"} ;
        boolean valida = comandoLsService.validar(arrayComando);
        Assertions.assertTrue(valida);
    }

    @Test
    void validarVacioTest() {
        String[] arrayComando = {"ls"," "} ;
        boolean valida = comandoLsService.validar(arrayComando);
        Assertions.assertTrue(valida);
    }

        @Test
    void validarSinVacioTest() {
        String[] arrayComando = {"ls",""} ;
        boolean valida = comandoLsService.validar(arrayComando);
        Assertions.assertTrue(valida);
    }

    @Test
    void validarMenosTest() {
        String[] arrayComando = {"ls","-"} ;
        boolean valida = comandoLsService.validar(arrayComando);
        Assertions.assertFalse(valida);
    }

    @Test
    void validarFalseTest() {
        String[] arrayComando = {"ls","-lalala"} ;
        boolean valida = comandoLsService.validar(arrayComando);
        Assertions.assertFalse(valida);
    }
}
