package com.desafio_tecnico.desafio.exception;

/**
 * Represents a standardized error response for API endpoints.
 *
 * @param code    a machine-readable error code
 * @param message a human-readable error message
 */
public record ErrorResponse(String code, String message) {}