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
    // Example of a custom validation method (if using Bean Validation 2.0+)
    // Uncomment if you want to enforce endDate > startDate
    /*
    @AssertTrue(message = "End date must be after start date")
    public boolean isEndDateValid() {
        return endDate == null || endDate.isAfter(startDate);
    }
    */
}