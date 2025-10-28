package com.desafio_tecnico.desafio.exception;

/**
 * Exceção lançada quando um projeto não é encontrado no sistema.
 */
public class ProjectNotFoundException extends RuntimeException {

  /**
   * Cria uma nova exceção com a mensagem especificada.
   * param message Mensagem descritiva do erro.
   */
  public ProjectNotFoundException(String message) {
    super(message);
  }

  /**
   * Cria uma nova exceção com a mensagem e a causa especificadas.
   * param message Mensagem descritiva do erro.
   * param cause Causa raiz da exceção.
   */
  public ProjectNotFoundException(String message, Throwable cause) {
    super(message, cause);
  }
}