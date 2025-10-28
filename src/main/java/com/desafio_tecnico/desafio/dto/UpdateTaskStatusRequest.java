package com.desafio_tecnico.desafio.dto;

import com.desafio_tecnico.desafio.entity.enums.TaskStatus;
import jakarta.validation.constraints.NotNull;

/**
 * DTO for updating the status of a Task.
 * Ensures that a non-null status is provided.
 */
public record UpdateTaskStatusRequest(
        @NotNull TaskStatus status
) {}