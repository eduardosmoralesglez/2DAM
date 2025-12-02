package com.docencia.restejercicio.repository;

import com.docencia.restejercicio.model.Task;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class TaskRepository {

    List<Task> listaTasks = new ArrayList<>();

    /**
     * Funcion para mostrar todas las Task de la lista
     * @return List<Task> con todas las Task
     */
    public List<Task> findAll() {
        return listaTasks;
    }

    /**
     * Funcion para buscar una Task por su Id en la lista
     * @param id Long con el ID del Task
     * @return Optional<Task> encontrado
     */
    public Optional<Task> findById(Long id) {
        for (Task task : listaTasks) {
            if (task.getId() == id) {
                return Optional.of(task);
            }
        }
        return null;
    }

    /**
     * Funcion para guardar una Task en la lista
     * @param task Task nueva a insertar
     * @return Task insertada
     */
    public Task save(Task task) {
        if (task.getId() == null) {
            task.setId(new AtomicLong(0).get());
        }
        listaTasks.add(task);
        return task;
    }

    /**
     * Funcion para eliminar una Task mediante su ID
     * @param id Long del Task a eliminar
     */
    public void deleteById(Long id) {
        listaTasks.remove(new Task(id));
    }

    /**
     * Funcion para comprobar la existencia de un Task en la lista
     * @param id Long del Task a comprobar
     * @return boolean true/false
     */
    public boolean existsById(Long id) {
        return listaTasks.contains(new Task(id));
    }
}
