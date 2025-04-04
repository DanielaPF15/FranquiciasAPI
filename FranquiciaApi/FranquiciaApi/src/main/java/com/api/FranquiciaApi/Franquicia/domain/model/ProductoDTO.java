package com.api.FranquiciaApi.Franquicia.domain.model;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductoDTO {
    private Integer id;
    private String nombre;
    private int stock;
    private Integer sucursalId;
}
