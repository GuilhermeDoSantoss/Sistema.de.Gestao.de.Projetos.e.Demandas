package com.desafio_tecnico.desafio.dto;

import com.desafio_tecnico.desafio.entity.enums.Priority;
import com.desafio_tecnico.desafio.entity.enums.TaskStatus;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

/**
 * DTO for creating a new Task.
 * Ensures required fields are present and valid.
 */
public record CreateTaskRequest(
        @NotBlank @Size(min = 5, max = 150) String title,
        String description,
        TaskStatus status,
        Priority priority,
        LocalDate dueDate,
        java.util.UUID projectId // Consider using UUID and/or custom validation
) {
    // Example of a custom validation method (if using Bean Validation 2.0+)
    // Uncomment if you want to enforce dueDate >= today
    /*
    @AssertTrue(message = "Due date must not be in the past")
    public boolean isDueDateValid() {
        return dueDate == null || !dueDate.isBefore(LocalDate.now());
    }
    */
}