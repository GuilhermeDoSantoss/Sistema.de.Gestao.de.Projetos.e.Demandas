package com.desafio_tecnico.desafio.service;

import com.desafio_tecnico.desafio.dto.CreateTaskRequest;
import com.desafio_tecnico.desafio.dto.UpdateTaskStatusRequest;
import com.desafio_tecnico.desafio.entity.Project;
import com.desafio_tecnico.desafio.entity.Task;
import com.desafio_tecnico.desafio.entity.enums.Priority;
import com.desafio_tecnico.desafio.entity.enums.TaskStatus;
import com.desafio_tecnico.desafio.exception.ProjectNotFoundException;
import com.desafio_tecnico.desafio.exception.TaskNotFoundException;
import com.desafio_tecnico.desafio.repository.ProjectRepository;
import com.desafio_tecnico.desafio.repository.TaskRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Service
@Transactional
public class TaskService {

    private final TaskRepository taskRepository;
    private final ProjectRepository projectRepository;

    public TaskService(TaskRepository taskRepository, ProjectRepository projectRepository) {
        this.taskRepository = taskRepository;
        this.projectRepository = projectRepository;
    }

    public Task createTask(CreateTaskRequest request) {
        Project project = projectRepository.findById(String.valueOf(request.projectId()))
                .orElseThrow(() -> new ProjectNotFoundException("Projeto não encontrado com ID: " + request.projectId()));

        Task task = new Task();
        task.setTitle(request.title());
        task.setDescription(request.description());
        task.setStatus(request.status() != null ? request.status() : TaskStatus.TODO);
        task.setPriority(request.priority() != null ? request.priority() : Priority.LOW);
        task.setDueDate(request.dueDate());
        task.setProject(project);

        // Exemplo de validação de data
        if (task.getDueDate() != null && task.getDueDate().isBefore(LocalDate.now())) {
            throw new IllegalArgumentException("A data de vencimento não pode ser no passado.");
        }

        return taskRepository.save(task);
    }

    @Transactional(readOnly = true)
    public List<Task> findTasks(TaskStatus status, Priority priority, String projectId) {
        if (status != null && priority != null && projectId != null) {
            return taskRepository.findByStatusAndPriorityAndProjectId(status, priority, projectId);
        } else if (status != null && projectId != null) {
            return taskRepository.findByStatusAndProjectId(status, projectId);
        } else if (priority != null && projectId != null) {
            return taskRepository.findByPriorityAndProjectId(priority, projectId);
        } else if (projectId != null) {
            return taskRepository.findByProjectId(projectId);
        } else if (status != null) {
            return taskRepository.findByStatus(status);
        } else if (priority != null) {
            return taskRepository.findByPriority(priority);
        } else {
            return taskRepository.findAll();
        }
    }

    public Task updateTaskStatus(String id, UpdateTaskStatusRequest request) {
        Task task = taskRepository.findById(id)
                .orElseThrow(() -> new TaskNotFoundException("Tarefa não encontrada com ID: " + id));
        if (task.getStatus() != request.status()) {
            task.setStatus(request.status());
            return taskRepository.save(task);
        }
        return task;
    }

    public void deleteTask(String id) {
        Task task = taskRepository.findById(id)
                .orElseThrow(() -> new TaskNotFoundException("Tarefa não encontrada com ID: " + id));
        taskRepository.delete(task);
    }
}