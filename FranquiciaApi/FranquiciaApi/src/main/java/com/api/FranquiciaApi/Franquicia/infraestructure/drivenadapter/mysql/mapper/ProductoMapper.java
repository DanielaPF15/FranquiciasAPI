package com.api.FranquiciaApi.Franquicia.infraestructure.drivenadapter.mysql.mapper;

import com.api.FranquiciaApi.Franquicia.domain.model.ProductoDTO;
import com.api.FranquiciaApi.Franquicia.infraestructure.drivenadapter.mysql.model.ProductoEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ProductoMapper {
    ProductoMapper INSTANCE = Mappers.getMapper(ProductoMapper.class);

    ProductoDTO toModel(ProductoEntity producto);
    ProductoEntity toEntity(ProductoDTO dto);
}
