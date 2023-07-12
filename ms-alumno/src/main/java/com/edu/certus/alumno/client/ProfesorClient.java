package com.edu.certus.alumno.client;

import com.edu.certus.alumno.dto.ResponseDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "ms-profesor")
public interface ProfesorClient {
    @GetMapping("/v1/profesor")
    ResponseDto readAllProfesor();

    @GetMapping("/v1/profesor/{id}")
    ResponseDto readProfesor(@PathVariable("id") Long id);
    @GetMapping("/v1/profesor-curso")
    ResponseDto getAllProfesorCurso();

    @GetMapping("/v1/profesor-curso//id-profesor/{id}")
    ResponseDto getProfesorCurso(@PathVariable("id") Long id);


    @GetMapping("/v1/profesor-curso//id-curso/{id}")
    ResponseDto getCursoProfesor(@PathVariable("id") Long id);

}
