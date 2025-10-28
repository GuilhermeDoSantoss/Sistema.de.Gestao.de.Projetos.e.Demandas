package com.desafio_tecnico.desafio.dto;

/**
 * Response DTO for authentication endpoints.
 * Contains the JWT or access token issued after successful login.
 */
public record AuthResponse(String token) {
}