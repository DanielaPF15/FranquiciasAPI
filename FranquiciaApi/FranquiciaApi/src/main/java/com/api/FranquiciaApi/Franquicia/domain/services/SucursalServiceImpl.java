package com.api.FranquiciaApi.Franquicia.domain.services;

import com.api.FranquiciaApi.Franquicia.domain.model.SucursalDTO;
import com.api.FranquiciaApi.Franquicia.infraestructure.drivenadapter.mysql.FranquiciaRepository;
import com.api.FranquiciaApi.Franquicia.infraestructure.drivenadapter.mysql.SucursalRepository;
import com.api.FranquiciaApi.Franquicia.infraestructure.drivenadapter.mysql.mapper.SucursalMapper;
import com.api.FranquiciaApi.Franquicia.infraestructure.drivenadapter.mysql.model.FranquiciaEntity;
import com.api.FranquiciaApi.Franquicia.infraestructure.drivenadapter.mysql.model.SucursalEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SucursalServiceImpl implements SucursalService {
    private final SucursalRepository sucursalRepository;
    private final FranquiciaRepository franquiciaRepository;
    private final SucursalMapper sucursalMapper;

    public SucursalServiceImpl(SucursalRepository sucursalRepository, FranquiciaRepository franquiciaRepository,SucursalMapper sucursalMapper) {
        this.sucursalRepository = sucursalRepository;
        this.franquiciaRepository = franquiciaRepository;
        this.sucursalMapper =sucursalMapper;
    }

    @Override
    public SucursalDTO agregarSucursal(Integer franquiciaId, SucursalDTO sucursal) {
        Optional<FranquiciaEntity> franquicia = franquiciaRepository.findById(franquiciaId);
        if (franquicia.isPresent()) {
            sucursal.setFranquiciaId(franquicia.get().getId());
            SucursalEntity sucursalEntity =sucursalMapper.toEntity(sucursal);
            sucursalRepository.save(sucursalEntity);
            return sucursal;
        }
        throw new RuntimeException("Franquicia no encontrada");
    }

    @Override
    public SucursalDTO actualizarNombreSucursal(Integer franquiciaId, Integer sucursalId, String nombre) {
        Optional<SucursalEntity> sucursal = sucursalRepository.findById(sucursalId);
        if (sucursal.isPresent()) {
            SucursalEntity s = sucursal.get();
            s.setNombre(nombre);
            sucursalRepository.save(s);
            return sucursalMapper.toModel(s);
        }
        throw new RuntimeException("Sucursal no encontrada");
    }
}
