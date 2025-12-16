package com.docencia.restejercicio.service;

import com.docencia.restejercicio.model.Task;
import com.docencia.restejercicio.repository.TaskRepository;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TaskService {

    private final TaskRepository repository;

    @Autowired
    public TaskService(TaskRepository repository) {
        this.repository = repository;
    }

    /**
     * Funcion para mostrar todas las Tasks
     * @return List<Task> 
     */
    public List<Task> getAll() {
        return repository.findAll();
    }

    /**
     * Funcion para obtener una Task mediante su id
     * @param id Long con el ID
     * @return Task buscado
     */
    public Task getById(Long id) {
        return repository.findById(id).orElse(null);
    }

    /**
     * Funcion para crear una Task
     * @param task Task a crear
     * @return Task creada
     */
    public Task create(Task task) {
        return repository.save(task);
    }

    /**
     * Funcion para actualizar un Task mediante su ID
     * @param id Long del Id del Task a modificar
     * @param update Task con los datos actualizados
     * @return Task actualizado
     */
    public Task update(Long id, Task update) {
        Task taskToUpdate = repository.findById(id).orElse(null);
        if (taskToUpdate != null) {
            repository.deleteById(id);
            taskToUpdate = update;
            repository.save(taskToUpdate);
            return taskToUpdate;
        }
        return taskToUpdate;
    }

    /**
     * Funcion para eliminar un Task mediante su ID
     * @param id Long con el Id del Task a eliminar
     */
    public void delete(Long id) {
        repository.deleteById(id);
    }
}
