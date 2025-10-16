package com.desafio_tecnico.desafio.dto;

import com.desafio_tecnico.desafio.entity.enums.Priority;
import com.desafio_tecnico.desafio.entity.enums.TaskStatus;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;
import java.util.UUID;

public record CreateTaskRequest(@NotBlank @Size(min = 5, max = 150) String title,
                                String description,
                                TaskStatus status,
                                Priority priority,
                                LocalDate dueDate,
                                @NotNull UUID projectId) { }
