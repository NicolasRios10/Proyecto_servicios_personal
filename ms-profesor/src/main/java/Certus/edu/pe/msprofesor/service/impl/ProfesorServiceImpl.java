package Certus.edu.pe.msprofesor.service.impl;



import Certus.edu.pe.msprofesor.dto.ProfesorDto;
import Certus.edu.pe.msprofesor.dto.ResponseDto;
import Certus.edu.pe.msprofesor.entity.ProfesorEntity;
import Certus.edu.pe.msprofesor.repository.ProfesorRepository;
import Certus.edu.pe.msprofesor.service.ProfesorService;
import Certus.edu.pe.msprofesor.util.Constantes;
import Certus.edu.pe.msprofesor.util.Util;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class ProfesorServiceImpl implements ProfesorService{

    @Autowired
    private ProfesorRepository profesorRepository;

    @Override
    public ResponseDto getAllProfesor() {
        try {
            List<ProfesorEntity> listaProfesoresEntity = profesorRepository.findAll();
            List<ProfesorDto> listaProfesorDto = new ArrayList<ProfesorDto>();
            for (ProfesorEntity profesorEntity : listaProfesoresEntity) {
                listaProfesorDto.add(ProfesorDto.builder()
                .id(profesorEntity.getId())
                .nombreCompleto(profesorEntity.getNombre() + " " + profesorEntity.getApellidos())
                .sexo(profesorEntity.getSexo())
                .estado(profesorEntity.getEstado())
                .build());
            }
            return Util.getResponse(true, Constantes.OPERATION_SUCCESS, listaProfesorDto);
        } catch (Exception e) {
            return Util.getResponse(false, Constantes.OPERATION_FAILED, null);
        }
    }

    @Override
    public ResponseDto getProfesor(Long id) {
        try {
            ProfesorEntity profesorEntity= profesorRepository.findById(id).orElse(null);
            if(null == profesorEntity) {
                return Util.getResponse(true, Constantes.NO_RECORDS_ROUND, null);
            }
            ProfesorDto profesorDto = ProfesorDto.builder()
                    .id(profesorEntity.getId())
                    .nombreCompleto(profesorEntity.getNombre() + " " + profesorEntity.getApellidos())
                    .sexo(profesorEntity.getSexo())
                    .estado(profesorEntity.getEstado())
                    .build();
            return Util.getResponse(true, Constantes.OPERATION_SUCCESS, profesorDto);
        } catch (Exception e) {
            return Util.getResponse(false, Constantes.OPERATION_FAILED, null);
        }
    }

    @Override
    public ResponseDto createProfesor(ProfesorDto profesor) {
        try {
            ProfesorEntity profesorEntity = ProfesorEntity.builder()
                    .nombre(profesor.getNombre())
                    .apellidos(profesor.getApellido())
                    .sexo(profesor.getSexo())
                    .estado(true)
                    .build();
            profesorRepository.save(profesorEntity);
            profesor.setId(profesorEntity.getId());
            return Util.getResponse(true, Constantes.OPERATION_SUCCESS, profesor);
        } catch (Exception e) {
            return Util.getResponse(false, Constantes.OPERATION_FAILED, null);
        }
    }

    @Override
    public ResponseDto updateProfesor(ProfesorDto profesor) {
        try {
            ProfesorEntity profesorEntity= profesorRepository.findById(profesor.getId()).orElse(null);
            if(null == profesorEntity) {
                return Util.getResponse(true, Constantes.NO_RECORDS_ROUND, null);
            }
            profesorEntity.setNombre(profesor.getNombre());
            profesorEntity.setApellidos(profesor.getApellido());
            profesorEntity.setSexo(profesor.getSexo());
            profesorRepository.save(profesorEntity);
            return Util.getResponse(true, Constantes.OPERATION_SUCCESS, profesor);
        } catch (Exception e) {
            return Util.getResponse(false, Constantes.OPERATION_FAILED, null);
        }
    }

    @Override
    public ResponseDto deteleProfesor(Long id) {
        try {
            ProfesorEntity profesorEntity= profesorRepository.findById(id).orElse(null);
            profesorEntity.setEstado(false);
            profesorRepository.save(profesorEntity);
            return Util.getResponse(true, Constantes.OPERATION_SUCCESS, null);
        } catch (Exception e) {
            log.error(Constantes.OPERATION_FAILED, e);
            return Util.getResponse(false, Constantes.OPERATION_FAILED, null);
        }
    }
}
