package com.desafio_tecnico.desafio.dto;

import com.desafio_tecnico.desafio.entity.enums.TaskStatus;
import jakarta.validation.constraints.NotNull;

/**
 * DTO para atualização do status de uma Tarefa.
 * Garante que um status não nulo seja fornecido.
 */
public record UpdateTaskStatusRequest(
        @NotNull TaskStatus status
) {}