package com.api.FranquiciaApi.Franquicia.domain.model;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SucursalDTO {
    private Integer id;
    private String nombre;
    private Integer franquiciaId;
}
