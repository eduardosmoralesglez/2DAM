package com.docencia.hotel.persistence;

import com.docencia.hotel.model.Guest;
import com.docencia.hotel.persistence.jpa.GuestJpaRepository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@ActiveProfiles("test")
class GuestJpaRepositoryTest {

    @Autowired
    private GuestJpaRepository guestRepository;

    private Guest baseGuest; 
    
    @BeforeEach
    @Transactional
    void beforeEach() {
        Guest g = new Guest();
        g.setName("guest_name");
        g.setEmail("guest_email");
        g.setPhone("guest_phone");

        baseGuest = guestRepository.save(g);
        assertThat(baseGuest.getId()).isNotNull();
    }

    @Test
    @Transactional
    void createReadFindByTitleTest() {
        String id = baseGuest.getId();

        Guest leida = guestRepository.findById(id);
        assertThat(leida).isNotNull();
        assertThat(leida.getName()).isEqualTo("guest_name");
        assertThat(leida.getEmail()).isEqualTo("guest_email");
        assertThat(leida.getPhone()).isEqualTo("guest_phone");

        Guest buscadaPorTitulo = guestRepository.find(leida);
        assertThat(buscadaPorTitulo).isNotNull();
        assertThat(buscadaPorTitulo.getId()).isEqualTo(id);
    }

    @Test
    @Transactional
    void updateContentTest() {
        String id = baseGuest.getId();

        baseGuest.setName("contenido modificado");
        Guest actualizada = guestRepository.save(baseGuest);

        assertThat(actualizada.getName())
                .isEqualTo("contenido modificado");

        Guest reread = guestRepository.findById(id);
        assertThat(reread.getName())
                .isEqualTo("contenido modificado");
    }

    @Test
    @Transactional
    void findByIdTest() {
        String id = baseGuest.getId();

        boolean exists = guestRepository.exists(id);

        assertThat(exists).isTrue();
    }

    @Test
    @Transactional
    void deleteNoteTest() {
        String id = baseGuest.getId();

        boolean borrada = guestRepository.delete(id);

        assertThat(borrada).isTrue();
        assertThat(guestRepository.exists(id)).isFalse();
        assertThat(guestRepository.findById(id)).isNull();
    }
}
