package com.edu.certus.curso.repository;

import com.edu.certus.curso.entity.CursoProfesorEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CursoProfesorRepository extends JpaRepository<CursoProfesorEntity, Long> {
    CursoProfesorEntity findByIdCurso(Long id);
}
