package com.api.FranquiciaApi.Franquicia.domain.services;

import com.api.FranquiciaApi.Franquicia.domain.gateway.FranquiciaGateway;
import com.api.FranquiciaApi.Franquicia.domain.model.FranquiciaDTO;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
@AllArgsConstructor
@Slf4j
public class FranquiciaServiceImpl implements FranquiciaService {

    private static final String ERROR_KEY = "error";
    private static final String MESSAGE_KEY = "message";
    private static final String DATA_KEY = "data";
    private static final String ID_KEY = "Id";

    private FranquiciaGateway franquiciaGateway;

    @Override
    public ResponseEntity<Map<String, Object>> crearFranquicia(FranquiciaDTO franquiciaDTO) {
        return Optional.ofNullable(franquiciaGateway.findByNombre(franquiciaDTO.getNombre()))
                .map(dto -> createErrorResponse("Ya existe una Franquicia con ese nombre", HttpStatus.CONFLICT))
                .orElseGet(() -> {
                    if (franquiciaDTO.getNombre() == null || franquiciaDTO.getNombre().isEmpty()) {
                        return createErrorResponse("El titulo no puede ser vacio", HttpStatus.CONFLICT);
                    }
                    franquiciaGateway.save(franquiciaDTO);
                    return createSuccessResponse(franquiciaDTO, "Se guardo correctamente", HttpStatus.CREATED);
                });
    }

    @Override
    public List<FranquiciaDTO> getFranquicias() {
        return franquiciaGateway.getFranquicias();
    }

    @Override
    public ResponseEntity<Map<String, Object>> eliminar(Integer id) {
        FranquiciaDTO franquiciaExistente = franquiciaGateway.findById(id);
        if (franquiciaExistente == null) {
            return createErrorResponse("No existe una franquicia asociada al id", HttpStatus.CONFLICT);
        }
        franquiciaGateway.delete(id);
        return createSuccessResponse(id, "Se elimino correctamente", HttpStatus.ACCEPTED);
    }

    @Override
    public ResponseEntity<Map<String, Object>> actualizar(FranquiciaDTO franquiciaDTO) {
        FranquiciaDTO franquiciaExistente = franquiciaGateway.findById(franquiciaDTO.getId());
        if (franquiciaExistente == null) {
            return createErrorResponse("No existe una franquicia asociada al id", HttpStatus.CONFLICT);
        }
        franquiciaGateway.update(franquiciaDTO);
        return createSuccessResponse(franquiciaDTO, "Se actualizo correctamente", HttpStatus.CREATED);
    }

    private ResponseEntity<Map<String, Object>> createErrorResponse(String message, HttpStatus status) {
        Map<String, Object> response = new HashMap<>();
        response.put(ERROR_KEY, true);
        response.put(MESSAGE_KEY, message);
        return new ResponseEntity<>(response, status);
    }

    private ResponseEntity<Map<String, Object>> createSuccessResponse(Object data, String message, HttpStatus status) {
        Map<String, Object> response = new HashMap<>();
        response.put(DATA_KEY, data);
        response.put(MESSAGE_KEY, message);
        return new ResponseEntity<>(response, status);
    }
}
