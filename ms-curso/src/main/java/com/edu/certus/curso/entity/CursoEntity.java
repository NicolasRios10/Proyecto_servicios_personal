package com.edu.certus.curso.entity;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Entity
@Table(name="curso")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CursoEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_curso")
	private Long id;
	@Column(name = "descripcion")
	private String descripcion;
	@Column(name = "estado")
	private Boolean estado ;

	@JoinColumn(name = "id_curso", referencedColumnName = "cod_curso", insertable = false, updatable = false)
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY, optional = false)
	private CursoProfesorEntity cursoProfesorEntity;
}
