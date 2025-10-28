package com.desafio_tecnico.desafio.dto;

import com.desafio_tecnico.desafio.entity.enums.Priority;
import com.desafio_tecnico.desafio.entity.enums.TaskStatus;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

/**
 * DTO para criação de uma nova Tarefa.
 * Garante que os campos obrigatórios estejam presentes e válidos.
 */
public record CreateTaskRequest(
        @NotBlank @Size(min = 5, max = 150) String title,
        String description,
        TaskStatus status,
        Priority priority,
        LocalDate dueDate,
        java.util.UUID projectId // Considere usar UUID e/ou validação customizada
) {
    // Exemplo de metodo de validação customizado (se estiver usando Bean Validation 2.0+)
    // Descomente se quiser garantir que dueDate >= hoje
    /*
        @AssertTrue(message = "A data de vencimento não pode ser no passado")
        public boolean isDueDateValid() {
            return dueDate == null || !dueDate.isBefore(LocalDate.now());
}
*/
}