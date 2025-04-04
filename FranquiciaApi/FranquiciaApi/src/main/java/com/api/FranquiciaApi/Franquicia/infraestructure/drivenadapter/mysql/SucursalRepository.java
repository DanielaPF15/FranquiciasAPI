package com.api.FranquiciaApi.Franquicia.infraestructure.drivenadapter.mysql;


import com.api.FranquiciaApi.Franquicia.infraestructure.drivenadapter.mysql.model.SucursalEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SucursalRepository extends JpaRepository<SucursalEntity,Integer> {
}
