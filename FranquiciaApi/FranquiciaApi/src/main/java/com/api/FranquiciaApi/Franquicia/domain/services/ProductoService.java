package com.api.FranquiciaApi.Franquicia.domain.services;

import com.api.FranquiciaApi.Franquicia.domain.model.ProductoDTO;

import java.util.List;

public interface ProductoService {
    ProductoDTO agregarProducto(Integer franquiciaId, Integer sucursalId, ProductoDTO producto);
    void eliminarProducto(Integer franquiciaId, Integer sucursalId, Integer productoId);
    ProductoDTO modificarStock(Integer franquiciaId, Integer sucursalId, Integer productoId, Integer stock);
    ProductoDTO actualizarNombreProducto(Integer franquiciaId, Integer sucursalId, Integer productoId, String nombre);
    List<ProductoDTO> obtenerProductosMaxStock(Integer franquiciaId, Integer sucursalId);
}
