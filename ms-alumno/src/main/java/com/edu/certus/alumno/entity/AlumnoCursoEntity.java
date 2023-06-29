package com.edu.certus.alumno.entity;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Entity
@Table(name = "alumno_curso")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AlumnoCursoEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_alumno_curso")
	private Long id;

	@Column(name = "cod_alumno")
	private Long idAlumno;

	@Column(name = "cod_curso")
	private Long idCurso;
}
