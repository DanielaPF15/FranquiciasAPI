package com.api.FranquiciaApi.Franquicia.domain.model;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SucursalDTO {
    private Long id;
    private String nombre;
    private Long franquiciaId;
}
