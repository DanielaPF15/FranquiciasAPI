package com.api.FranquiciaApi.Franquicia.infraestructure.drivenadapter.mysql.mapper;

import com.api.FranquiciaApi.Franquicia.domain.model.SucursalDTO;
import com.api.FranquiciaApi.Franquicia.infraestructure.drivenadapter.mysql.model.SucursalEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface SucursalMapper {
    @Mapping(source = "franquicia.id", target = "franquiciaId")
    SucursalDTO toModel(SucursalEntity sucursal);
    @Mapping(source = "franquiciaId", target = "franquicia.id")
    SucursalEntity toEntity(SucursalDTO dto);
}
