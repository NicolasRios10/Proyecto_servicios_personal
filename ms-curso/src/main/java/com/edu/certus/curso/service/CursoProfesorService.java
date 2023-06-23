package com.edu.certus.curso.service;

import com.edu.certus.curso.dto.CursoProfesorDto;
import com.edu.certus.curso.dto.ResponseDto;

public interface CursoProfesorService {
    public ResponseDto getAllCursoProfesor();
    public ResponseDto getCursoProfesor(Long id);

    public ResponseDto createCursoProfesor(CursoProfesorDto cursoProfesorDto);
}
