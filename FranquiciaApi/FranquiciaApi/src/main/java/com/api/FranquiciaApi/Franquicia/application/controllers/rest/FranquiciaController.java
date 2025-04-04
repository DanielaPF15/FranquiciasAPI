package com.api.FranquiciaApi.Franquicia.application.controllers.rest;

import com.api.FranquiciaApi.Franquicia.domain.model.FranquiciaDTO;
import com.api.FranquiciaApi.Franquicia.domain.services.FranquiciaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("franquicia")
@AllArgsConstructor
@Tag(name = "Franquicia", description = "Crud de franquicia")
public class FranquiciaController {

    @Autowired
    private final FranquiciaService franquiciaService;

    @Operation(description = "Consultar Franquicia")
    @GetMapping("/")
    public List<FranquiciaDTO> getFranquicias() {
        return franquiciaService.getFranquicias();
    }

    @Operation(description = "Crear Franquicia")
    @PostMapping("/crear")
    public ResponseEntity<Map<String, Object>> crearFranquicia(@RequestBody FranquiciaDTO franquiciaDTO) {
        return franquiciaService.crearFranquicia(franquiciaDTO);
    }

    @Operation(description = "Editar Franquicia")
    @PutMapping("/editar")
    public ResponseEntity<Map<String, Object>> actualizarFranquicia(@RequestBody FranquiciaDTO franquiciaDTO) {
        return franquiciaService.actualizar(franquiciaDTO);
    }

    @Operation(description = "Eliminar Franquicia")
    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Map<String, Object>> eliminarFranquicia(@PathVariable Integer id) {
        return franquiciaService.eliminar(id);
    }
}
