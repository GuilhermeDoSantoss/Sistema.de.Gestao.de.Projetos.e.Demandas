package com.desafio_tecnico.desafio.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

public record CreateProjectRequest(
        @NotBlank @Size(min = 3, max = 100) String name,
        String description,
        @NotNull LocalDate startDate,
        LocalDate endDate
) { }
