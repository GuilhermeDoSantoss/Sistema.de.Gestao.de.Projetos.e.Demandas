package com.desafio_tecnico.desafio.entity.enums;

/**
 * Enum que representa o status de uma tarefa.
 */
public enum TaskStatus {
    TODO("A Fazer"),
    DOING("Em Progresso"),
    DONE("Concluída");

    private final String descricao;

    TaskStatus(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }

    /**
     * Obtém o enum a partir de uma string, ignorando maiúsculas/minúsculas.
     * @param value Valor textual
     * @return TaskStatus correspondente ou null se não encontrado
     */
    public static TaskStatus fromString(String value) {
        for (TaskStatus status : TaskStatus.values()) {
            if (status.name().equalsIgnoreCase(value)) {
                return status;
            }
        }
        return null;
    }
}