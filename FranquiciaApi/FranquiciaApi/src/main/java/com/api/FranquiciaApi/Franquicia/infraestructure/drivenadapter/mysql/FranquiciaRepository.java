package com.api.FranquiciaApi.Franquicia.infraestructure.drivenadapter.mysql;


import com.api.FranquiciaApi.Franquicia.infraestructure.drivenadapter.mysql.model.FranquiciaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FranquiciaRepository extends JpaRepository<FranquiciaEntity,Integer> {
    @Query(value = "Select entity from FranquiciaEntity entity where entity.id = ?1")
    Optional<FranquiciaEntity> findByIdFranquicia(Integer id);

    @Query(value = "Select entity from FranquiciaEntity entity where entity.nombre = ?1")
    Optional<FranquiciaEntity> findByNombreFranquicia(String nombreFranquicia);
}
