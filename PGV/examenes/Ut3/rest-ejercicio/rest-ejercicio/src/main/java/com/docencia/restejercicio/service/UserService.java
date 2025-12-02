package com.docencia.restejercicio.service;

import com.docencia.restejercicio.model.User;
import com.docencia.restejercicio.repository.UserRepository;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository repository;

    @Autowired
    public UserService (UserRepository repository) {
        this.repository = repository;
    }

    /**
     * Funcion para mostrar todos los Users
     * @return List<User>
     */
    public List<User> getAll() {
        return repository.findAll();
    }

    /**
     * Funcion para obtener un User mediante su Id 
     * @param id Long con el Id del User buscado
     * @return User buscado
     */
    public User getById(Long id) {
        return repository.findById(id).orElse(null);
    }

    /**
     * Funcion para crear un nuevo User
     * @param user User a insertar
     * @return User creado
     */
    public User create(User user) {
       return repository.save(user);
    }

    /**
     * Funcion para actualizar los datos de un User mediante su Id
     * @param id Long con el Id del User a actualizar
     * @param update User con los nuevos datos
     * @return User con los datos actualizados
     */
    public User update(Long id, User update) {
        User userAUpdate = repository.findById(id).orElse(null);
        if (userAUpdate != null) {
            repository.deleteById(id);
            userAUpdate = update;
            repository.save(userAUpdate);
        }
        return userAUpdate;
    }

    /**
     * Funcion para eliminar un User mediante su ID
     * @param id Long con el Id del User a eliminar
     */
    public void delete(Long id) {
        repository.deleteById(id);
    }
}
