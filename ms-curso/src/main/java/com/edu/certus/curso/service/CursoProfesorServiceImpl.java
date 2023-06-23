package com.edu.certus.curso.service;


import com.edu.certus.curso.client.ProfesorClient;
import com.edu.certus.curso.dto.CursoProfesorDto;
import com.edu.certus.curso.dto.ProfesorDto;
import com.edu.certus.curso.dto.ResponseDto;
import com.edu.certus.curso.entity.CursoEntity;
import com.edu.certus.curso.entity.CursoProfesorEntity;
import com.edu.certus.curso.repository.CursoProfesorRepository;
import com.edu.certus.curso.repository.CursoRepository;
import com.edu.certus.curso.util.Util;
import com.edu.certus.curso.util.Constantes;
import com.fasterxml.jackson.databind.ObjectMapper;
import feign.RetryableException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class CursoProfesorServiceImpl implements CursoProfesorService {

    @Autowired
    private CursoProfesorRepository cursoProfesorRepository;

    @Autowired
    private CursoRepository cursoRepository;

    @Autowired
    private ProfesorClient profesorClient;

    @Override
    public ResponseDto getAllCursoProfesor() {
        ObjectMapper mapper = new ObjectMapper();
        try {
            List<CursoProfesorEntity> listCursoProfesorEntity = cursoProfesorRepository.findAll();
            List<CursoProfesorDto> listCursoProfesorDto = new ArrayList<CursoProfesorDto>();

            for (int i = 0; i < listCursoProfesorEntity.size(); i++) {
                CursoEntity cursoEntity = cursoRepository.findById(listCursoProfesorEntity.get(i).getIdCurso()).orElse(null);
                ResponseDto responseDto = profesorClient.readProfesor(listCursoProfesorEntity.get(i).getIdProfesor());
                ProfesorDto profesorDto = mapper.convertValue(responseDto.getData(), ProfesorDto.class);

                listCursoProfesorDto.add(CursoProfesorDto.builder()
                        .idCurso(cursoEntity.getId())
                        .nombreCurso(cursoEntity.getDescripcion())
                        .estadoCurso(cursoEntity.getEstado())
                        .idProfesor(profesorDto.getId())
                        .nombreProfesor(profesorDto.getNombreCompleto())
                        .build());
            }
            return Util.getResponse(true, Constantes.OPERATION_SUCCESS, listCursoProfesorDto);
        } catch (RetryableException ex) {
            log.error("RetryableException: " + Constantes.NO_SERVICE_AVAILABLE + " " + ex);
            return Util.getResponse(false, Constantes.NO_SERVICE_AVAILABLE, null);
        } catch (Exception e) {
            log.error("Exception: " + Constantes.OPERATION_FAILED + " " + e);
            return Util.getResponse(false, Constantes.OPERATION_FAILED, null);
        }
    }

    @Override
    public ResponseDto getCursoProfesor(Long id) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            CursoProfesorEntity cursoProfesorEntity = cursoProfesorRepository.findByIdCurso(id);
            if (cursoProfesorEntity == null) {
                return Util.getResponse(true, Constantes.NO_RECORDS_ROUND, null);

            }

            CursoEntity cursoEntity = cursoRepository.findById(cursoProfesorEntity.getIdCurso()).orElse(null);
            ResponseDto responseDto = profesorClient.readProfesor(cursoProfesorEntity.getIdProfesor());
            ProfesorDto profesorDto = mapper.convertValue(responseDto.getData(), ProfesorDto.class);

            CursoProfesorDto cursoProfesorDto = CursoProfesorDto.builder()
                    .idCurso(cursoEntity.getId())
                    .nombreCurso(cursoEntity.getDescripcion())
                    .estadoCurso(cursoEntity.getEstado())
                    .idProfesor(profesorDto.getId())
                    .nombreProfesor(profesorDto.getNombreCompleto())
                    .estadoProfesor(profesorDto.getEstado())
                    .build();
            return Util.getResponse(true, Constantes.OPERATION_SUCCESS, cursoProfesorDto);
        } catch (RetryableException ex) {
            log.error("RetryableException: " + Constantes.NO_SERVICE_AVAILABLE + " " + ex);
            return Util.getResponse(false, Constantes.NO_SERVICE_AVAILABLE, null);
        } catch (Exception e) {
            log.error("Exception: " + Constantes.OPERATION_FAILED + " " + e);
            return Util.getResponse(false, Constantes.OPERATION_FAILED, null);
        }
    }

    @Override
    public ResponseDto createCursoProfesor (CursoProfesorDto cursoProfesorDto){
        try {
            CursoProfesorEntity cursoProfesorEntity = CursoProfesorEntity.builder()
                    .idCurso(cursoProfesorDto.getIdCurso())
                    .idProfesor(cursoProfesorDto.getIdProfesor())
                    .build();
            cursoProfesorRepository.save(cursoProfesorEntity);

            return Util.getResponse(true, Constantes.OPERATION_SUCCESS, null);
        } catch (Exception e) {
            return Util.getResponse(false, Constantes.OPERATION_FAILED, null);
        }
    }

}
