package com.edu.certus.alumno.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.edu.certus.alumno.entity.AlumnoCursoEntity;

import java.util.List;

@Repository
public interface AlumnoCursoRepository extends JpaRepository<AlumnoCursoEntity, Long>{
	List<AlumnoCursoEntity> findByIdAlumno(Long idAlumno);
}
