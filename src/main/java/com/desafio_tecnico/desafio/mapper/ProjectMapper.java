package com.desafio_tecnico.desafio.mapper;

import com.desafio_tecnico.desafio.dto.CreateProjectRequest;
import com.desafio_tecnico.desafio.entity.Project;
import org.mapstruct.Mapper;

/**
 * Mapper para converter CreateProjectRequest em Project.
 */
@Mapper(componentModel = "spring")
public interface ProjectMapper {
    /**
     * Converte um DTO de criação de projeto em uma entidade Project.
     * param dto DTO de criação de projeto
     * return Entidade Project
     */
    Project toEntity(CreateProjectRequest dto);
}