package com.edu.certus.curso.controller;

import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.edu.certus.curso.dto.CursoDto;
import com.edu.certus.curso.dto.ResponseDto;
import com.edu.certus.curso.service.CursoService;

@RestController
@RequestMapping("/v1/curso")
public class CursoController {
	
	@Autowired
	private CursoService cursoService;
	@ApiOperation(value = "Método para listar todos los cursos")
	@GetMapping()
	public ResponseEntity<ResponseDto> readAllCurso(){
		return ResponseEntity.status(HttpStatus.OK).body(cursoService.getAllCurso());
	}
	@ApiOperation(value = "Método para listar los cursos por su id")
	@GetMapping("/{id}")
	public ResponseEntity<ResponseDto> readCurso(@PathVariable("id")Long id){
		return ResponseEntity.status(HttpStatus.OK).body(cursoService.getCurso(id));
	}
	@ApiOperation(value = "Método para crear un curso")
	@PostMapping
	public ResponseEntity<ResponseDto> createCurso(@RequestBody CursoDto curso){
		return ResponseEntity.status(HttpStatus.CREATED).body(cursoService.createCurso(curso));
	}
	@ApiOperation(value = "Método para acutalizar un curso")
	@PutMapping
	public ResponseEntity<ResponseDto> updateCurso(@RequestBody CursoDto curso){
		return ResponseEntity.status(HttpStatus.CREATED).body(cursoService.updateCurso(curso));
	}
	@ApiOperation(value = "Método para eliminar un curso")
	@DeleteMapping("/{id}")
	public ResponseEntity<ResponseDto> deleteCurso(@PathVariable("id")Long id){
		return ResponseEntity.status(HttpStatus.OK).body(cursoService.deteleCurso(id));
	}

	@ApiOperation(value = "Método para obtener todos los profesor cursos ")
	@GetMapping("/all-profesor")
	public ResponseEntity<ResponseDto> getAllProfesorCurso(){
		return ResponseEntity.status(HttpStatus.OK).body(cursoService.getAllProfesorCurso());
	}
}