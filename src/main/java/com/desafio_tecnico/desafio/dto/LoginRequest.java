package com.desafio_tecnico.desafio.dto;

import jakarta.validation.constraints.NotBlank;

/**
 * DTO para requisição de login.
 * Garante que username e password não sejam vazios.
 */
public record LoginRequest(
        @NotBlank String username,
        @NotBlank String password
) {}