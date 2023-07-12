package com.edu.certus.alumno.service.impl;

import com.edu.certus.alumno.client.CursoClient;
import com.edu.certus.alumno.client.ProfesorClient;

import com.edu.certus.alumno.dto.*;
import com.edu.certus.alumno.entity.AlumnoCursoEntity;
import com.edu.certus.alumno.entity.AlumnoEntity;
import com.edu.certus.alumno.repository.AlumnoCursoRepository;
import com.edu.certus.alumno.repository.AlumnoRepository;
import com.edu.certus.alumno.service.AlumnoCursoProfesorService;
import com.edu.certus.alumno.util.Constante;
import com.edu.certus.alumno.util.Util;
import com.fasterxml.jackson.databind.ObjectMapper;
import feign.RetryableException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.fasterxml.jackson.core.type.TypeReference;


import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class AlumnoCursoProfesorServiceImpl implements AlumnoCursoProfesorService {

    @Autowired
    private AlumnoCursoRepository alumnoCursoRepository;

    @Autowired
    private AlumnoRepository alumnoRepository;

    @Autowired
    private CursoClient cursoClient;

    @Autowired
    private ProfesorClient profesorClient;



    @Override
    public ResponseDto getAllAlumnoCursoProfesor() {
        ObjectMapper mapper = new ObjectMapper();
        try {

            List<AlumnoCursoEntity> listAlumnoCursoEntity = alumnoCursoRepository.findAll();

            List<AlumnoCursoProfesorDto> listAlumnoCursoProfesorDto = new ArrayList<AlumnoCursoProfesorDto>();

            for (AlumnoCursoEntity alumnoCursoEntity : listAlumnoCursoEntity) {

                AlumnoEntity alumnoEntity = alumnoRepository.findById(alumnoCursoEntity.getIdAlumno()).orElse(null);

                ResponseDto responseCursoDto = cursoClient.readCurso(alumnoCursoEntity.getIdCurso());
                CursoDto cursoDto = mapper.convertValue(responseCursoDto.getData(), CursoDto.class);

                ResponseDto responseCursoProfesorDto = profesorClient.getCursoProfesor(alumnoCursoEntity.getIdCurso());
                String jsonResponseCursoProfesorDto = mapper.writeValueAsString(responseCursoProfesorDto.getData());
                List<ProfesorCursoDto> listProfesorCursoDto = mapper.readValue(jsonResponseCursoProfesorDto, new TypeReference<List<ProfesorCursoDto>>() {});

                for (int i = 0; i < listProfesorCursoDto.size(); i++) {
                    listAlumnoCursoProfesorDto.add(AlumnoCursoProfesorDto.builder()
                            .idAlumno(alumnoEntity.getId())
                            .nombreAlumno(alumnoEntity.getNombres() + " " + alumnoEntity.getApellidos())
                            .estadoAlumno(alumnoEntity.getEstado())
                            .idCurso(cursoDto.getId())
                            .nombreCurso(cursoDto.getDescripcion())
                            .idProfesor(listProfesorCursoDto.get(i).getIdProfesor())
                            .nombreProfesor(listProfesorCursoDto.get(i).getNombreProfesor())
                            .build());
                }
            }

            return Util.getResponse(true, Constante.OPERATION_SUCCESS, listAlumnoCursoProfesorDto);
        } catch (RetryableException ex) {
            log.error(Constante.NO_SERVICE_AVIABLE, ex);
            return Util.getResponse(false, Constante.NO_SERVICE_AVIABLE, null);
        } catch (Exception e) {
            log.error(Constante.OPERATION_FAILED, e);
            return Util.getResponse(false, Constante.OPERATION_FAILED, null);
        }
    }
}
