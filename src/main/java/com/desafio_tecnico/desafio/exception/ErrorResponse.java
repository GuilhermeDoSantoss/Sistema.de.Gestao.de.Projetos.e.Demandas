package com.desafio_tecnico.desafio.exception;

/**
 * Representa uma resposta de erro padronizada para endpoints da API.
 *
 * param code    um código de erro legível por máquina
 * param message uma mensagem de erro legível por humanos
 */
public record ErrorResponse(String code, String message) {}