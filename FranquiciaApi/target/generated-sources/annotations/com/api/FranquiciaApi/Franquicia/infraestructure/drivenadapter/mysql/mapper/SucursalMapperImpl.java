package com.api.FranquiciaApi.Franquicia.infraestructure.drivenadapter.mysql.mapper;

import com.api.FranquiciaApi.Franquicia.domain.model.SucursalDTO;
import com.api.FranquiciaApi.Franquicia.infraestructure.drivenadapter.mysql.model.SucursalEntity;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-04-03T22:08:10-0500",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 17.0.14 (Oracle Corporation)"
)
@Component
public class SucursalMapperImpl implements SucursalMapper {

    @Override
    public SucursalDTO toModel(SucursalEntity sucursal) {
        if ( sucursal == null ) {
            return null;
        }

        SucursalDTO.SucursalDTOBuilder sucursalDTO = SucursalDTO.builder();

        sucursalDTO.id( sucursal.getId() );
        sucursalDTO.nombre( sucursal.getNombre() );

        return sucursalDTO.build();
    }

    @Override
    public SucursalEntity toEntity(SucursalDTO dto) {
        if ( dto == null ) {
            return null;
        }

        SucursalEntity sucursalEntity = new SucursalEntity();

        sucursalEntity.setId( dto.getId() );
        sucursalEntity.setNombre( dto.getNombre() );

        return sucursalEntity;
    }
}
