package com.desafio_tecnico.desafio.dto;

import com.desafio_tecnico.desafio.entity.Task;
import com.desafio_tecnico.desafio.entity.enums.TaskStatus;
import com.desafio_tecnico.desafio.entity.enums.Priority;

public record TaskResponse(
        String id,
        String title,
        String description,
        TaskStatus status,
        Priority priority,
        String projectId
) {
    public static TaskResponse fromEntity(Task task) {
        if (task == null) return null;
        String projectId = task.getProject() != null ? task.getProject().getId() : null;
        return new TaskResponse(
                task.getId(),
                task.getTitle(),
                task.getDescription(),
                task.getStatus(),
                task.getPriority(),
                projectId
        );
    }
}