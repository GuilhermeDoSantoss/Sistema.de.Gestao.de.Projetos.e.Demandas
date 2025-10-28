package com.desafio_tecnico.desafio.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

/**
 * DTO for creating a new Project.
 * Ensures required fields are present and valid.
 */
public record CreateProjectRequest(
        @NotBlank @Size(min = 3, max = 100) String name,
        String description,
        @NotNull LocalDate startDate,
        LocalDate endDate
) {
    // Exemplo de metodo de validação customizado (se estiver usando Bean Validation 2.0+)
// Descomente se quiser garantir que endDate > startDate
/*
    @AssertTrue(message = "A data de término deve ser posterior à data de início")
    public boolean isEndDateValid() {
    return endDate == null || endDate.isAfter(startDate);
}
*/
}