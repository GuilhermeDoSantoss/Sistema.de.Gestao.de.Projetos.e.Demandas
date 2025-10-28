package com.desafio_tecnico.desafio.service;

import com.desafio_tecnico.desafio.dto.CreateProjectRequest;
import com.desafio_tecnico.desafio.entity.Project;
import com.desafio_tecnico.desafio.mapper.ProjectMapper;
import com.desafio_tecnico.desafio.repository.ProjectRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ProjectService {

    private final ProjectRepository projectRepository;
    private final ProjectMapper projectMapper;

    public ProjectService(ProjectRepository projectRepository, ProjectMapper projectMapper) {
        this.projectRepository = projectRepository;
        this.projectMapper = projectMapper;
    }

    public Project createProject(CreateProjectRequest request) {
        // Exemplo de validação simples
        if (request.startDate() != null && request.endDate() != null &&
                request.startDate().isAfter(request.endDate())) {
            throw new IllegalArgumentException("Start date must be before end date");
        }
        Project project = projectMapper.toEntity(request);
        return projectRepository.save(project);
    }

    @Transactional(readOnly = true)
    public List<Project> getAllProjects() {
        return projectRepository.findAll();
    }
}