package com.desafio_tecnico.desafio.controller;

import com.desafio_tecnico.desafio.dto.CreateProjectRequest;
import com.desafio_tecnico.desafio.dto.ProjectResponse;
import com.desafio_tecnico.desafio.entity.Project;
import com.desafio_tecnico.desafio.service.ProjectService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/projects")
@Validated
public class ProjectController {

    private final ProjectService projectService;

    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }

    /**
     * Cria um novo projeto.
     * param request a requisição de criação do projeto
     * return o projeto criado
     */
    @PostMapping
    public ResponseEntity<ProjectResponse> createProject(@Valid @RequestBody CreateProjectRequest request) {
        Project project = projectService.createProject(request);
        ProjectResponse response = ProjectResponse.fromEntity(project);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    /**
     * Recupera todos os projetos.
     * return lista de projetos
     */
    @GetMapping
    public ResponseEntity<List<ProjectResponse>> getAllProjects() {
        List<Project> projects = projectService.getAllProjects();
        List<ProjectResponse> responses = projects.stream()
                .map(ProjectResponse::fromEntity)
                .toList();
        return ResponseEntity.ok(responses);
    }
}