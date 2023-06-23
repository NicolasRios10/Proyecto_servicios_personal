package com.edu.certus.curso.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CursoProfesorDto {
    private Long idCurso;
    private String nombreCurso;
    private Boolean estadoCurso;
    private Long idProfesor;
    private String nombreProfesor;
    private Boolean estadoProfesor;
}
