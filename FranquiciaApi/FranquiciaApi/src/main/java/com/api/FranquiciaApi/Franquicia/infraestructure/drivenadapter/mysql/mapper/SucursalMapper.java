package com.api.FranquiciaApi.Franquicia.infraestructure.drivenadapter.mysql.mapper;

import com.api.FranquiciaApi.Franquicia.domain.model.SucursalDTO;
import com.api.FranquiciaApi.Franquicia.infraestructure.drivenadapter.mysql.model.SucursalEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface SucursalMapper {
    SucursalMapper INSTANCE = Mappers.getMapper(SucursalMapper.class);

    SucursalDTO toModel(SucursalEntity sucursal);
    SucursalEntity toEntity(SucursalDTO dto);
}
