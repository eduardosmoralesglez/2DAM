package com.docencia.tasks.adapters.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.docencia.tasks.adapters.in.api.TaskRequest;
import com.docencia.tasks.adapters.in.api.TaskResponse;
import com.docencia.tasks.domain.model.Task;
import com.docencia.tasks.entitys.TaskEntity;

@Mapper(componentModel = "spring")
public interface TaskMapper {

    @Mapping(source = "identificador", target = "id")
    @Mapping(source = "titulo", target = "title")
    @Mapping(source = "descripcion", target = "description")
    @Mapping(source = "completado", target = "completed")
    public Task requestToTask(TaskRequest source);

    public List<Task> toTaskList(List<TaskRequest> requests);

    public Task entityToTask(TaskEntity source);

    public List<Task> entityToTaskList(List<TaskEntity> entities);

    public TaskResponse taskToResponse(Task task);
}
