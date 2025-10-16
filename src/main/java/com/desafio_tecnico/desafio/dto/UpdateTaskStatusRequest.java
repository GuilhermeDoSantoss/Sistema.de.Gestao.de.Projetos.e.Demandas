package com.desafio_tecnico.desafio.dto;

import com.desafio_tecnico.desafio.entity.enums.TaskStatus;
import jakarta.validation.constraints.NotNull;

public record UpdateTaskStatusRequest(@NotNull TaskStatus status) {
}
