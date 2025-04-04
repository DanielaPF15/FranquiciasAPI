package com.api.FranquiciaApi.Franquicia.infraestructure.drivenadapter.mysql.mapper;

import com.api.FranquiciaApi.Franquicia.domain.model.FranquiciaDTO;
import com.api.FranquiciaApi.Franquicia.infraestructure.drivenadapter.mysql.model.FranquiciaEntity;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-04-04T00:33:37-0500",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 17.0.14 (Oracle Corporation)"
)
@Component
public class FranquiciaMapperImpl implements FranquiciaMapper {

    @Override
    public FranquiciaDTO toModel(FranquiciaEntity franquicia) {
        if ( franquicia == null ) {
            return null;
        }

        FranquiciaDTO.FranquiciaDTOBuilder franquiciaDTO = FranquiciaDTO.builder();

        franquiciaDTO.id( franquicia.getId() );
        franquiciaDTO.nombre( franquicia.getNombre() );

        return franquiciaDTO.build();
    }

    @Override
    public FranquiciaEntity toEntity(FranquiciaDTO dto) {
        if ( dto == null ) {
            return null;
        }

        FranquiciaEntity franquiciaEntity = new FranquiciaEntity();

        franquiciaEntity.setId( dto.getId() );
        franquiciaEntity.setNombre( dto.getNombre() );

        return franquiciaEntity;
    }
}
