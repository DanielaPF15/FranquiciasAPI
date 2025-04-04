package com.api.FranquiciaApi.Franquicia.infraestructure.drivenadapter.mysql.mapper;

import com.api.FranquiciaApi.Franquicia.domain.model.ProductoDTO;
import com.api.FranquiciaApi.Franquicia.infraestructure.drivenadapter.mysql.model.ProductoEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ProductoMapper {

    @Mapping(source = "sucursal.id", target = "sucursalId")
    ProductoDTO toModel(ProductoEntity producto);
    @Mapping(source = "sucursalId", target = "sucursal.id")
    ProductoEntity toEntity(ProductoDTO dto);
}
