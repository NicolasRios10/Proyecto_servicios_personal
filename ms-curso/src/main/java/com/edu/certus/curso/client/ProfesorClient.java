package com.edu.certus.curso.client;

import com.edu.certus.curso.dto.ResponseDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="ms-profesor", url = "http://localhost:9005")
public interface ProfesorClient {

    @GetMapping("/v1/profesor")
    ResponseDto readAllProfesor();

    @GetMapping("/v1/profesor/{id}")
    ResponseDto readProfesor(@PathVariable("id") Long id);
}
