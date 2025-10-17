package com.desafio_tecnico.desafio.mapper;

import com.desafio_tecnico.desafio.dto.CreateTaskRequest;
import com.desafio_tecnico.desafio.dto.UpdateTaskStatusRequest;
import com.desafio_tecnico.desafio.entity.Task;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", uses = ProjectMapper.class)
public interface TaskMapper {

    TaskMapper INSTANCE = Mappers.getMapper(TaskMapper.class);

    Task toEntity(CreateTaskRequest dto);
    Task toEntity(UpdateTaskStatusRequest dto, @MappingTarget Task task); //MappingTarget permite atualizar uma entidade (útil no PUT)
}
