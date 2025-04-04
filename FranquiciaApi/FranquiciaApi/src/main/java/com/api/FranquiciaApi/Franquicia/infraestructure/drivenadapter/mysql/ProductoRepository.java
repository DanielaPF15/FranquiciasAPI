package com.api.FranquiciaApi.Franquicia.infraestructure.drivenadapter.mysql;

import com.api.FranquiciaApi.Franquicia.infraestructure.drivenadapter.mysql.model.ProductoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductoRepository extends JpaRepository<ProductoEntity, Integer> {

    @Query("SELECT p FROM ProductoEntity p WHERE p.sucursal.id = :sucursalId ORDER BY p.stock DESC")
    List<ProductoEntity> findMaxStockBySucursal(Integer sucursalId);
}
