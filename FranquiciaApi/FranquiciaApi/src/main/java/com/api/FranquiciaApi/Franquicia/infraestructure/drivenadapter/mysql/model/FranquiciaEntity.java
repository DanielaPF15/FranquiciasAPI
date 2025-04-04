package com.api.FranquiciaApi.Franquicia.infraestructure.drivenadapter.mysql.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.antlr.v4.runtime.misc.NotNull;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "franquicia")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FranquiciaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull
    @Column(name = "nombre")
    private String nombre;

    @OneToMany(mappedBy = "franquicia", cascade = CascadeType.ALL)
    private List<SucursalEntity> sucursales;
}
