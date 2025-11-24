package com.docencia.personas.service;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.docencia.personas.model.Rol;
import com.docencia.personas.services.IRolService;


@SpringBootTest
public class RolServiceTest {
    
    private static final String ROL_NOMBRE = "NOMBRE";
    private static final String ROL_ID = "ROL_ID";
    IRolService rolService;
    Rol rol;

    @Autowired
    public void setRolService(IRolService rolService) {
        this.rolService = rolService;
    }

    @BeforeEach
    void beforeEach() {
        if (rol == null) {
            rol = new Rol(ROL_ID, ROL_NOMBRE);
        }
        rolService.save(rol);

    }

    @AfterEach
    void afterEach() {
        Rol rolDelete = new Rol(ROL_ID);
        rolService.delete(rolDelete);
        rolDelete = rolService.findBy(rolDelete);
        Assertions.assertNull(rolDelete);
    }

    @Test
    void findByTest() {
        Rol rolFind = new Rol(ROL_ID);
        rolFind = rolService.findBy(rolFind);
        Assertions.assertNotNull(rolFind);
        Assertions.assertEquals(rol, rolFind);
        Assertions.assertEquals(ROL_ID, rolFind.getId());
        Assertions.assertEquals(ROL_NOMBRE, rolFind.getNombre());
    }

    @Test
    void deleteTest() {

    }
}
