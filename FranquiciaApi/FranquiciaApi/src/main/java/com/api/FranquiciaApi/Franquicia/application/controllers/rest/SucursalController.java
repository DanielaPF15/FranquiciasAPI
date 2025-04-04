package com.api.FranquiciaApi.Franquicia.application.controllers.rest;

import com.api.FranquiciaApi.Franquicia.domain.model.SucursalDTO;
import com.api.FranquiciaApi.Franquicia.domain.services.SucursalService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/franquicias/{franquiciaId}/sucursales")
public class SucursalController {

    private final SucursalService sucursalService;

    public SucursalController(SucursalService sucursalService) {
        this.sucursalService = sucursalService;
    }

    @PostMapping
    public ResponseEntity<SucursalDTO> agregarSucursal(@PathVariable Integer franquiciaId, @RequestBody SucursalDTO sucursalDTO) {
        return ResponseEntity.ok(sucursalService.agregarSucursal(franquiciaId, sucursalDTO));
    }

    @PutMapping("/{sucursalId}")
    public ResponseEntity<SucursalDTO> actualizarNombreSucursal(@PathVariable Integer franquiciaId, @PathVariable Integer sucursalId, @RequestParam String nombre) {
        return ResponseEntity.ok(sucursalService.actualizarNombreSucursal(franquiciaId, sucursalId, nombre));
    }
}
