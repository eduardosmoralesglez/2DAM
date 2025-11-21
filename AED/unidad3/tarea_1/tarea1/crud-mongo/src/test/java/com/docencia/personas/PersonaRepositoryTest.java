package com.docencia.personas;

import com.docencia.personas.model.Direccion;
import com.docencia.personas.model.Persona;
import com.docencia.personas.repository.PersonaRepository;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest
@ActiveProfiles("test")
public class PersonaRepositoryTest {

    private PersonaRepository personaRepository;
    private Persona personaColection;
    private Persona personaFind;
    private Direccion direccion;
    private String email = "unEmail@email.com";
    private String ciudad = "UnaCiudad";

    @Autowired
    public void setPersonaRepository(PersonaRepository personaRepository) {
        this.personaRepository = personaRepository;
    }

    @BeforeEach
    void cleanDataBase() {
        personaRepository.deleteAll();
        direccion = new Direccion("UnaCalle", ciudad, "38313", "ESPAÑA");
        personaColection = new Persona("test", 18, email, direccion);
        personaFind = personaRepository.save(personaColection);
    }

    @Test
    void testFind() {
        Assertions.assertEquals(1, personaRepository.count());
        Assertions.assertNotNull(personaFind);
        Assertions.assertNotNull(personaFind.getId());
    }


    @Test
    void testFindByCiudad() {
        List<Persona> list = personaRepository.findByCiudad(ciudad);
        Assertions.assertEquals(1, list.size());
        Assertions.assertEquals(list.get(0), personaFind);
    }

    @Test
    void testFindByEdadBetween() {
        Persona persona35 = new Persona("Persona35", 35, email, direccion);
        Persona persona42 = new Persona("Persona42", 42, email, direccion);
        personaRepository.save(persona35);
        personaRepository.save(persona42);
        List<Persona> list1020 = personaRepository.findByEdadBetween(10, 20);
        Assertions.assertEquals(1, list1020.size());
        List<Persona> list2050 = personaRepository.findByEdadBetween(20, 50);
        Assertions.assertEquals(2, list2050.size());
    }

    @Test
    void testFindByEmail() {
        Optional<Persona> personaOptional = personaRepository.findByEmail(email);
        Assertions.assertEquals(Optional.of(personaFind), personaOptional);
    }
    
    @Test
    void testFindByNombreContainingIgnoreCase() {
        List<Persona> list = personaRepository.findByNombreContainingIgnoreCase("test");
        Assertions.assertNotNull(list);
        Assertions.assertEquals(1, list.size());
        Assertions.assertEquals(list.get(0).getNombre(), "test");
    }

}