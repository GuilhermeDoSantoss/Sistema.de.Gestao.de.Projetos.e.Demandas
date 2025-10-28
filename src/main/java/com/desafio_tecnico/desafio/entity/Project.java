package com.desafio_tecnico.desafio.entity;

import java.time.LocalDate;
import java.util.UUID;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
@Entity
@Table(name = "projects")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Project {

    @Id
    @Column(length = 36)
    private String id;

    @NotBlank
    @Size(min = 3, max = 100)
    private String name;

    private String description;

    @NotNull
    private LocalDate startDate;

    private LocalDate endDate;

    public Project(String test, Object o, LocalDate now, Object o1) {
    }

    // Gera o ID automaticamente antes de persistir, se não estiver setado
    @PrePersist
    public void generateId() {
        if (this.id == null) {
            this.id = UUID.randomUUID().toString();
        }
    }
}