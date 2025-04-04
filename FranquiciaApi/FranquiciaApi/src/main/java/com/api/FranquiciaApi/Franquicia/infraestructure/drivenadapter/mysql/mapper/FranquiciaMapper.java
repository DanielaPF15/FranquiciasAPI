package com.api.FranquiciaApi.Franquicia.infraestructure.drivenadapter.mysql.mapper;


import com.api.FranquiciaApi.Franquicia.domain.model.FranquiciaDTO;
import com.api.FranquiciaApi.Franquicia.infraestructure.drivenadapter.mysql.model.FranquiciaEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;


@Mapper(componentModel = "spring")
public interface FranquiciaMapper {
    FranquiciaMapper INSTANCE = Mappers.getMapper(FranquiciaMapper.class);

    FranquiciaDTO toModel(FranquiciaEntity franquicia);
    FranquiciaEntity toEntity(FranquiciaDTO dto);}
