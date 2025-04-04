package com.api.FranquiciaApi.Franquicia.infraestructure.drivenadapter.mysql.mapper;

import com.api.FranquiciaApi.Franquicia.domain.model.ProductoDTO;
import com.api.FranquiciaApi.Franquicia.infraestructure.drivenadapter.mysql.model.ProductoEntity;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-04-03T22:08:10-0500",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 17.0.14 (Oracle Corporation)"
)
@Component
public class ProductoMapperImpl implements ProductoMapper {

    @Override
    public ProductoDTO toModel(ProductoEntity producto) {
        if ( producto == null ) {
            return null;
        }

        ProductoDTO.ProductoDTOBuilder productoDTO = ProductoDTO.builder();

        productoDTO.id( producto.getId() );
        productoDTO.nombre( producto.getNombre() );
        productoDTO.stock( producto.getStock() );

        return productoDTO.build();
    }

    @Override
    public ProductoEntity toEntity(ProductoDTO dto) {
        if ( dto == null ) {
            return null;
        }

        ProductoEntity productoEntity = new ProductoEntity();

        productoEntity.setId( dto.getId() );
        productoEntity.setNombre( dto.getNombre() );
        productoEntity.setStock( dto.getStock() );

        return productoEntity;
    }
}
