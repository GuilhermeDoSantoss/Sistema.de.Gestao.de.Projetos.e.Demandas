package com.desafio_tecnico.desafio.entity.enums;

/**
 * Enum que representa os níveis de prioridade de uma tarefa.
 */
public enum Priority {
    LOW("Baixa"),
    MEDIUM("Média"),
    HIGH("Alta");

    private final String descricao;

    Priority(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }

    /**
     * Obtém o enum a partir de uma string, ignorando maiúsculas/minúsculas.
     * @param value Valor textual
     * @return Priority correspondente ou null se não encontrado
     */
    public static Priority fromString(String value) {
        for (Priority p : Priority.values()) {
            if (p.name().equalsIgnoreCase(value)) {
                return p;
            }
        }
        return null;
    }
}