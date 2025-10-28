package com.desafio_tecnico.desafio.exception;

/**
 * Exceção lançada quando uma tarefa não é encontrada no sistema.
 */
public class TaskNotFoundException extends RuntimeException {
  /**
   * Cria uma nova exceção com a mensagem especificada.
   * @param message Mensagem descritiva do erro.
   */
  public TaskNotFoundException(String message) {
    super(message);
  }

  /**
   * Cria uma nova exceção com a mensagem e a causa especificadas.
   * @param message Mensagem descritiva do erro.
   * @param cause Causa raiz da exceção.
   */
  public TaskNotFoundException(String message, Throwable cause) {
    super(message, cause);
  }
}