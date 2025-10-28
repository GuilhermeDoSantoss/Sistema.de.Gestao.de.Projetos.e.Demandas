package com.desafio_tecnico.desafio.repository;

import com.desafio_tecnico.desafio.entity.Task;
import com.desafio_tecnico.desafio.entity.enums.Priority;
import com.desafio_tecnico.desafio.entity.enums.TaskStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Repositório para operações CRUD e consultas customizadas de Task.
 */
@Repository
public interface TaskRepository extends JpaRepository<Task, String> {
    List<Task> findByStatus(TaskStatus status);
    List<Task> findByPriority(Priority priority);
    List<Task> findByProjectId(String projectId);
    List<Task> findByStatusAndPriority(TaskStatus status, Priority priority);
    List<Task> findByStatusAndPriorityAndProjectId(TaskStatus status, Priority priority, String projectId);
    List<Task> findByStatusAndProjectId(TaskStatus status, String projectId);
    List<Task> findByPriorityAndProjectId(Priority priority, String projectId);
}