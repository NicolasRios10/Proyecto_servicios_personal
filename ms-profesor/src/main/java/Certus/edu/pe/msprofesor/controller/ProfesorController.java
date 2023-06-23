package Certus.edu.pe.msprofesor.controller;

import Certus.edu.pe.msprofesor.dto.ProfesorDto;
import Certus.edu.pe.msprofesor.service.ProfesorService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import Certus.edu.pe.msprofesor.dto.ResponseDto;

@RestController
@RequestMapping("/v1/profesor")
public class ProfesorController {

    @Autowired
    private ProfesorService profesorService;

    @ApiOperation(value = "Método para listar todos los profesores")
    @GetMapping()
    public ResponseEntity<ResponseDto> readAllProfesor(){
        return ResponseEntity.status(HttpStatus.OK).body(profesorService.getAllProfesor());
    }
    @ApiOperation(value = "Método para listar a los porfesores por su id")
    @GetMapping("/{id}")
    public ResponseEntity<ResponseDto> readProfesor(@PathVariable("id")Long id){
        return ResponseEntity.status(HttpStatus.OK).body(profesorService.getProfesor(id));
    }
    @ApiOperation(value = "Método para crear un profesor")
    @PostMapping
    public ResponseEntity<ResponseDto> createProfesor(@RequestBody ProfesorDto profesor){
        return ResponseEntity.status(HttpStatus.CREATED).body(profesorService.createProfesor(profesor));
    }
    @ApiOperation(value = "Método para actualizar los profesores")
    @PutMapping
    public ResponseEntity<ResponseDto> updateProfesor(@RequestBody ProfesorDto profesor){
        return ResponseEntity.status(HttpStatus.CREATED).body(profesorService.updateProfesor(profesor));
    }
    @ApiOperation(value = "Método para eliminar un porfesor")
    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseDto> deleteProfesor(@PathVariable("id")Long id){
        return ResponseEntity.status(HttpStatus.OK).body(profesorService.deteleProfesor(id));
    }
}
