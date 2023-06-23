package com.edu.certus.alumno.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.edu.certus.alumno.dto.AlumnoCursoDto;
import com.edu.certus.alumno.dto.ResponseDto;
import com.edu.certus.alumno.service.AlumnoCursoService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/v1/alumno-curso")
public class AlumnoCursoController {

	@Autowired
	private AlumnoCursoService alumnoCursoService;
	
	@ApiOperation(value = "Método para listar todos alumnos-cursos")
	@GetMapping
	public ResponseEntity<ResponseDto> getAllAlumnoCurso(){
		return ResponseEntity.status(HttpStatus.OK).body(alumnoCursoService.getAllAlumnoCurso());
	}
	
	@ApiOperation(value = "Método para listar alumnos-curso")
	@GetMapping("/{id}")
	public ResponseEntity<ResponseDto> getAlumnoCurso(@PathVariable("id") Long id){
		return ResponseEntity.status(HttpStatus.OK).body(alumnoCursoService.getAlumnoCurso(id));
	}
	
	@ApiOperation(value = "Método para asignar alumno-curso")
	@PostMapping
	public ResponseEntity<ResponseDto> createAlumnoCurso(@RequestBody AlumnoCursoDto alumnoCursoDto){
		return ResponseEntity.status(HttpStatus.CREATED).body(alumnoCursoService.createAlumnoCurso(alumnoCursoDto));
	}
}
