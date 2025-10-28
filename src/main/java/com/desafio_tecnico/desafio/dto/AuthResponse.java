package com.desafio_tecnico.desafio.dto;

/**
 * DTO de resposta para endpoints de autenticação.
 * Contém o JWT ou token de acesso emitido após login bem-sucedido.
 */
public record AuthResponse(String token) {
}