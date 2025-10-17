package com.desafio_tecnico.desafio;

import com.desafio_tecnico.desafio.entity.Project;
import com.desafio_tecnico.desafio.repository.ProjectRepository;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.time.LocalDate;

@SpringBootTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@TestPropertySource(locations = "classpath:application-test.yml")
class TaskControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ProjectRepository projectRepository;

    @Test
    void shouldCreateTask() throws Exception {
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
                .andExpect(MockMvcResultMatchers.status().is(409));
    }
}
