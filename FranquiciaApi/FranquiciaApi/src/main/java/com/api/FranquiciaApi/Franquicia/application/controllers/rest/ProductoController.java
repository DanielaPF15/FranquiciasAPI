package com.api.FranquiciaApi.Franquicia.application.controllers.rest;

import com.api.FranquiciaApi.Franquicia.domain.model.ProductoDTO;
import com.api.FranquiciaApi.Franquicia.domain.services.ProductoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/franquicias/{franquiciaId}/sucursales/{sucursalId}/productos")
public class ProductoController {

    private final ProductoService productoService;

    public ProductoController(ProductoService productoService) {
        this.productoService = productoService;
    }

    @PostMapping
    public ResponseEntity<ProductoDTO> agregarProducto(@PathVariable Integer franquiciaId, @PathVariable Integer sucursalId, @RequestBody ProductoDTO producto) {
        return ResponseEntity.ok(productoService.agregarProducto(franquiciaId, sucursalId, producto));
    }

    @DeleteMapping("/{productoId}")
    public ResponseEntity<Void> eliminarProducto(@PathVariable Integer franquiciaId, @PathVariable Integer sucursalId, @PathVariable Integer productoId) {
        productoService.eliminarProducto(franquiciaId, sucursalId, productoId);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{productoId}/stock")
    public ResponseEntity<ProductoDTO> modificarStock(@PathVariable Integer franquiciaId, @PathVariable Integer sucursalId, @PathVariable Integer productoId, @RequestParam Integer stock) {
        return ResponseEntity.ok(productoService.modificarStock(franquiciaId, sucursalId, productoId, stock));
    }

    @PutMapping("/{productoId}")
    public ResponseEntity<ProductoDTO> actualizarNombreProducto(@PathVariable Integer franquiciaId, @PathVariable Integer sucursalId, @PathVariable Integer productoId, @RequestParam String nombre) {
        return ResponseEntity.ok(productoService.actualizarNombreProducto(franquiciaId, sucursalId, productoId, nombre));
    }

    @GetMapping("/max-stock")
    public ResponseEntity<List<ProductoDTO>> obtenerProductosMaxStock(@PathVariable Integer franquiciaId, @PathVariable Integer sucursalId) {
        return ResponseEntity.ok(productoService.obtenerProductosMaxStock(franquiciaId, sucursalId));
    }
}
