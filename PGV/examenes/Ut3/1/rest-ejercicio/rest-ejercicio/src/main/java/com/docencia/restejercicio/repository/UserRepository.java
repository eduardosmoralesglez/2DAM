package com.docencia.restejercicio.repository;

import com.docencia.restejercicio.model.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class UserRepository {

    private List<User> listaUsuarios = new ArrayList<>();

    /**
     * Funcion para mostrar todos los usuarios de la lista
     * @return List<User> con todos los Users
     */
    public List<User> findAll() {
        return listaUsuarios;
    }

    /**
     * Funcion para buscar un User por su ID en la lista
     * @param id Long del ID del User a buscar
     * @return Optional<User> con el User buscado
     */
    public Optional<User> findById(Long id) {
        for (User user : listaUsuarios) {
            if (user.getId() == id) {
                return Optional.of(user);
            }
        }
        return null;
    }

    /**
     * Funcion para guardad un User en la lista
     * @param user User a guardar
     * @return User guardado
     */
    public User save(User user) {
        if (user.getId() == null) {
            user.setId(new AtomicLong(0).get());
        }
        listaUsuarios.add(user);
        return user;
    }

    /**
     * Funcion para eliminar un User de la lista mediante su ID
     * @param id Long con el ID del User a eliminar
     */
    public void deleteById(Long id) {
        listaUsuarios.remove(new User(id));
    }

    /**
     * Funcion para comprobar la existencia de un User mediante su ID
     * @param id Long con el ID del usuario a buscar
     * @return boolean true/false
     */
    public boolean existsById(Long id) {
        return listaUsuarios.contains(new User(id));
    }
}
