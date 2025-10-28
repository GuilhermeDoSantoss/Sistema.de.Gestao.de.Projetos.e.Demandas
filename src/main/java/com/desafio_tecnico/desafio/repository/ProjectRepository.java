package com.desafio_tecnico.desafio.repository;

import com.desafio_tecnico.desafio.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

/**
 * Repositório para operações CRUD com a entidade Project.
 */
@Repository
public interface ProjectRepository extends JpaRepository<Project, String> {
    // Exemplo de método customizado:
    // List<Project> findByName(String name);
}