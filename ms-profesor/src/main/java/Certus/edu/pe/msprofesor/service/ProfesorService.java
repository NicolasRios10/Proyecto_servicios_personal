package Certus.edu.pe.msprofesor.service;

import Certus.edu.pe.msprofesor.dto.ProfesorDto;
import Certus.edu.pe.msprofesor.dto.ResponseDto;

public interface ProfesorService {

    public ResponseDto getAllProfesor();
    public ResponseDto getProfesor(Long id);
    public ResponseDto createProfesor(ProfesorDto profesor);
    public ResponseDto updateProfesor(ProfesorDto profesor);
    public ResponseDto deteleProfesor(Long id);
}
