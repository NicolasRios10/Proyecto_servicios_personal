package Certus.edu.pe.msprofesor.util;

import Certus.edu.pe.msprofesor.dto.ResponseDto;

public class Util {
    public static ResponseDto getResponse(boolean success, String mensaje, Object data) {
        ResponseDto response = new ResponseDto();
        String cod = (!success) ? Constantes.CODE_FAILED : Constantes.CODE_SUCESS;
        response.setCodigo(cod);
        response.setMensaje(mensaje);
        response.setData(data);
        return response;
    }
}
