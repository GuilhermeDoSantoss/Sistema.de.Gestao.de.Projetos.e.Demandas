package com.desafio_tecnico.desafio;

import com.desafio_tecnico.desafio.entity.Project;
import com.desafio_tecnico.desafio.repository.ProjectRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;

@SpringBootTest
@AutoConfigureMockMvc
@TestPropertySource(locations = "classpath:application-test.yml")
@Transactional // Garante rollback após cada teste
class TaskControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ProjectRepository projectRepository;

    @Test
    void shouldCreateTaskSuccessfully() throws Exception {
        Project project = projectRepository.save(new Project("Test", null, LocalDate.now(), null));

        String json = """
                {
                  "title": "Nova tarefa",
                  "projectId": "%s"
                }
                """.formatted(project.getId());

        mockMvc.perform(MockMvcRequestBuilders.post("/tasks")
                        .contentType("application/json")
                        .content(json))
                .andExpect(MockMvcResultMatchers.status().isCreated())
                .andExpect(MockMvcResultMatchers.jsonPath("$.title").value("Nova tarefa"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").exists());
    }
}