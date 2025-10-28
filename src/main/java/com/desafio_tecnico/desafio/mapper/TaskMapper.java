package com.desafio_tecnico.desafio.mapper;

import com.desafio_tecnico.desafio.dto.CreateTaskRequest;
import com.desafio_tecnico.desafio.dto.UpdateTaskStatusRequest;
import com.desafio_tecnico.desafio.entity.Task;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

/**
 * Mapper para conversão entre DTOs de Task e a entidade Task.
 */
@Mapper(componentModel = "spring", uses = ProjectMapper.class)
public interface TaskMapper {
    /**
     * Converte um CreateTaskRequest em uma entidade Task.
     */
    Task toEntity(CreateTaskRequest dto);

    /**
     * Atualiza uma entidade Task existente com dados de UpdateTaskStatusRequest.
     * param dto DTO com os dados de atualização
     * param task Entidade Task a ser atualizada
     * return Task atualizada
     */
    Task toEntity(UpdateTaskStatusRequest dto, @MappingTarget Task task);
}