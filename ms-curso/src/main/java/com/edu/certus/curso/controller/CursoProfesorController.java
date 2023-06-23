package com.edu.certus.curso.controller;

import com.edu.certus.curso.dto.CursoProfesorDto;
import com.edu.certus.curso.dto.ResponseDto;
import com.edu.certus.curso.service.CursoProfesorService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/curso-profesor")
public class CursoProfesorController {

    @Autowired
    private CursoProfesorService cursoProfesorService;

    @ApiOperation(value = "Método para listar todos cursos-profesores")
    @GetMapping
    public ResponseEntity<ResponseDto> getAllCursoProgesor(){
        return ResponseEntity.status(HttpStatus.OK).body(cursoProfesorService.getAllCursoProfesor());
    }

    @ApiOperation(value = "Método para listar curso-profesores por su id")
    @GetMapping("/{id}")
    public ResponseEntity<ResponseDto> getCursoProfesor(@PathVariable("id") Long id){
        return ResponseEntity.status(HttpStatus.OK).body(cursoProfesorService.getCursoProfesor(id));
    }

    @ApiOperation(value = "Método para asignar curso-profesor")
    @PostMapping
    public ResponseEntity<ResponseDto> createCursoProfesor(@RequestBody CursoProfesorDto cursoProfesorDto){
        return ResponseEntity.status(HttpStatus.CREATED).body(cursoProfesorService.createCursoProfesor(cursoProfesorDto));
    }
}
