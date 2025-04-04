package com.api.FranquiciaApi.Franquicia.domain.services;

import com.api.FranquiciaApi.Franquicia.domain.model.FranquiciaDTO;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Map;

public interface FranquiciaService {
    ResponseEntity<Map<String, Object>> crearFranquicia(FranquiciaDTO franquiciaDTO);

    List<FranquiciaDTO> getFranquicias();

    ResponseEntity<Map<String, Object>> eliminar(Integer id);

    ResponseEntity<Map<String, Object>> actualizar(FranquiciaDTO franquiciaDTO);
}
