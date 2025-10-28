package com.desafio_tecnico.desafio.dto;

import com.desafio_tecnico.desafio.entity.Project;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;
import java.util.UUID;

public class ProjectResponse {
    private UUID id;
    private String name;
    private String description;
    private LocalDate startDate;
    private LocalDate endDate;

    // Construtor padrão
    public ProjectResponse(String id,
                           @NotBlank @Size(min = 3, max = 100) String name,
                           String description,
                           @NotNull LocalDate startDate,
                           LocalDate endDate) {}

    // Construtor completo
    public ProjectResponse(UUID id, String name, String description, LocalDate startDate, LocalDate endDate) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public UUID getId() {
        return id; }
    public void setId(UUID id) {
        this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public LocalDate getStartDate() { return startDate; }
    public void setStartDate(LocalDate startDate) { this.startDate = startDate; }

    public LocalDate getEndDate() { return endDate; }
    public void setEndDate(LocalDate endDate) { this.endDate = endDate; }

    // Metodo utilitário para converter entidade em DTO
    public static ProjectResponse fromEntity(Project project) {
        if (project == null) return null;
        return new ProjectResponse(
                project.getId(),
                project.getName(),
                project.getDescription(),
                project.getStartDate(),
                project.getEndDate()
        );
    }
}