package com.desafio_tecnico.desafio.controller;

import com.desafio_tecnico.desafio.dto.CreateTaskRequest;
import com.desafio_tecnico.desafio.dto.TaskResponse;
import com.desafio_tecnico.desafio.dto.UpdateTaskStatusRequest;
import com.desafio_tecnico.desafio.entity.enums.Priority;
import com.desafio_tecnico.desafio.entity.enums.TaskStatus;
import com.desafio_tecnico.desafio.service.TaskService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/tasks")
@Validated
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    /**
     * Creates a new task.
     */
    @PostMapping
    public ResponseEntity<TaskResponse> createTask(@Valid @RequestBody CreateTaskRequest request) {
        var task = taskService.createTask(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(TaskResponse.fromEntity(task));
    }

    /**
     * Retrieves tasks, optionally filtered by status, priority, and project.
     */
    @GetMapping
    public ResponseEntity<List<TaskResponse>> getTasks(
            @RequestParam(required = false) TaskStatus status,
            @RequestParam(required = false) Priority priority,
            @RequestParam(required = false) String projectId) {
        UUID projectUuid = null;
        if (projectId != null && !projectId.isBlank()) {
            try {
                projectUuid = UUID.fromString(projectId);
            } catch (IllegalArgumentException e) {
                return ResponseEntity.badRequest().build();
            }
        }
        var tasks = taskService.findTasks(status, priority, projectUuid != null ? projectUuid.toString() : null);
        var responses = tasks.stream().map(TaskResponse::fromEntity).collect(Collectors.toList());
        return ResponseEntity.ok(responses);
    }

    /**
     * Updates the status of a task.
     */
    @PutMapping("/{id}/status")
    public ResponseEntity<TaskResponse> updateTaskStatus(
            @PathVariable String id,
            @Valid @RequestBody UpdateTaskStatusRequest request) {
        var updated = taskService.updateTaskStatus(id, request);
        return ResponseEntity.ok(TaskResponse.fromEntity(updated));
    }

    /**
     * Deletes a task.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTask(@PathVariable String id) {
        taskService.deleteTask(id);
        return ResponseEntity.noContent().build();
    }
}