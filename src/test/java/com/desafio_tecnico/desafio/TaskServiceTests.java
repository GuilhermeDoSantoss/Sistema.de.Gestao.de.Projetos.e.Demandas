package com.desafio_tecnico.desafio;

import com.desafio_tecnico.desafio.dto.CreateTaskRequest;
import com.desafio_tecnico.desafio.entity.Project;
import com.desafio_tecnico.desafio.entity.Task;
import com.desafio_tecnico.desafio.repository.ProjectRepository;
import com.desafio_tecnico.desafio.repository.TaskRepository;
import com.desafio_tecnico.desafio.service.TaskService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class TaskServiceTests {

    @Mock
    private TaskRepository taskRepository;
    @Mock
    private ProjectRepository projectRepository;

    @InjectMocks
    private TaskService taskService;

    @Test
    void shouldCreateTask() {
        // given
        UUID projectId = UUID.randomUUID();
        Project project = new Project();
        when(projectRepository.findById(projectId)).thenReturn(Optional.of(project));
        when(taskRepository.save(any())).thenAnswer(inv -> inv.getArgument(0));

        CreateTaskRequest request = new CreateTaskRequest("Título", "Desc", null, null, null, projectId);

        // when
        Task result = taskService.createTask(request);

        // then
        assertThat(result.getTitle()).isEqualTo("Título");
        verify(taskRepository).save(any());
    }
}
