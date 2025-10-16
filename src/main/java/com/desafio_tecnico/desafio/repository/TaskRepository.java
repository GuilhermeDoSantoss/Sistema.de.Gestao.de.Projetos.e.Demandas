package com.desafio_tecnico.desafio.repository;

import com.desafio_tecnico.desafio.entity.Task;
import com.desafio_tecnico.desafio.entity.enums.Priority;
import com.desafio_tecnico.desafio.entity.enums.TaskStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface TaskRepository extends JpaRepository<Task, UUID> {
    List<Task> findByStatus(TaskStatus status);
    List<Task> findByPriority(Priority priority);
    List<Task> findByProjectId(UUID projectId);
    List<Task> findByStatusAndPriority(TaskStatus status, Priority priority);
}
