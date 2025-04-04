package com.api.FranquiciaApi.Franquicia.infraestructure.drivenadapter.mysql.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "sucursal")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SucursalEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nombre;

    @ManyToOne
    @JoinColumn(name = "franquicia_id")
    private FranquiciaEntity franquicia;

    @OneToMany(mappedBy = "sucursal", cascade = CascadeType.ALL)
    private List<ProductoEntity> productos;

}
