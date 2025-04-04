package com.api.FranquiciaApi.Franquicia.domain.services;

import com.api.FranquiciaApi.Franquicia.domain.model.SucursalDTO;

public interface SucursalService {
    SucursalDTO agregarSucursal(Integer franquiciaId, SucursalDTO sucursal);
    SucursalDTO actualizarNombreSucursal(Integer franquiciaId, Integer sucursalId, String nombre);
}