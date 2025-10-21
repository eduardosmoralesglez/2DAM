package org.formacion.procesos.services;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ComandosPsServiceTest {

    ComandoPsService comandoPsService;
    String[] arrayComando;

    @BeforeEach
    void beforeEach() {
        comandoPsService = new ComandoPsService();
        comandoPsService.setComando("ps");
    }

    @Test
    void validarTest() {
        String[] arrayComando = {"ps","-xa"} ;
        boolean valida = comandoPsService.validar(arrayComando);
        Assertions.assertTrue(valida);
    }

    @Test
    void validarSinGuionTest() {
        String[] arrayComando = {"ps","xa"} ;
        boolean valida = comandoPsService.validar(arrayComando);
        Assertions.assertTrue(valida);
    }

    @Test
    void validarAuxTest() {
        String[] arrayComando = {"ps","-aux"} ;
        boolean valida = comandoPsService.validar(arrayComando);
        Assertions.assertTrue(valida);
    }

    @Test
    void validarMenosAuxTest() {
        String[] arrayComando = {"ps","aux"} ;
        boolean valida = comandoPsService.validar(arrayComando);
        Assertions.assertTrue(valida);
    }

    @Test
    void validarVacioTest() {
        String[] arrayComando = {"ps"," "} ;
        boolean valida = comandoPsService.validar(arrayComando);
        Assertions.assertTrue(valida);
    }

        @Test
    void validarSinVacioTest() {
        String[] arrayComando = {"ps",""} ;
        boolean valida = comandoPsService.validar(arrayComando);
        Assertions.assertTrue(valida);
    }

    @Test
    void validarMenosTest() {
        String[] arrayComando = {"ps","-"} ;
        boolean valida = comandoPsService.validar(arrayComando);
        Assertions.assertFalse(valida);
    }

    @Test
    void validarFalseTest() {
        String[] arrayComando = {"ps","-xaaaaaaa"} ;
        boolean valida = comandoPsService.validar(arrayComando);
        Assertions.assertFalse(valida);
    }
}
