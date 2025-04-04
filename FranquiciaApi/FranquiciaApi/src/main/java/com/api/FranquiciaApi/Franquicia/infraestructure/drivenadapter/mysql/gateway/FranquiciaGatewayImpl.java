package com.api.FranquiciaApi.Franquicia.infraestructure.drivenadapter.mysql.gateway;

import com.api.FranquiciaApi.Franquicia.domain.gateway.FranquiciaGateway;
import com.api.FranquiciaApi.Franquicia.domain.model.FranquiciaDTO;
import com.api.FranquiciaApi.Franquicia.infraestructure.drivenadapter.mysql.FranquiciaRepository;
import com.api.FranquiciaApi.Franquicia.infraestructure.drivenadapter.mysql.mapper.FranquiciaMapper;
import com.api.FranquiciaApi.Franquicia.infraestructure.drivenadapter.mysql.model.FranquiciaEntity;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
@AllArgsConstructor
public class FranquiciaGatewayImpl implements FranquiciaGateway {
    private FranquiciaRepository repository;
    private FranquiciaMapper mapper;

    @Override
    public FranquiciaDTO save(FranquiciaDTO franquiciaDTO) {
        FranquiciaEntity franquiciaEntity = repository.save(mapper.toEntity(franquiciaDTO));
        return mapper.toModel(franquiciaEntity);
    }

    @Override
    public FranquiciaDTO update(FranquiciaDTO FranquiciaDTO) {
        FranquiciaEntity entity = mapper.toEntity(FranquiciaDTO);
        FranquiciaEntity saved = repository.save(entity);
        return mapper.toModel(saved);
    }

    @Override
    public FranquiciaDTO findById(Integer id) {
        Optional<FranquiciaEntity> optionalFranquiciaEntity = repository.findById(id);
        if (optionalFranquiciaEntity.isPresent()) {
            FranquiciaEntity FranquiciaEntity = optionalFranquiciaEntity.get();
            return mapper.toModel(FranquiciaEntity);
        } else {
            return null;
        }
    }

    @Override
    public void delete(Integer id) {
        Optional<FranquiciaEntity> optionalFranquiciaEntity = repository.findByIdFranquicia(id);
        if (optionalFranquiciaEntity.isPresent()) {
            FranquiciaEntity franquiciaEntity = optionalFranquiciaEntity.get();
            repository.deleteById(franquiciaEntity.getId());
        }
    }

    public List<FranquiciaDTO> getFranquicias() {
        List<FranquiciaEntity> franquiciasEntity = repository.findAll();
        List<FranquiciaDTO> franquiciafins = new ArrayList<>();
        franquiciasEntity.forEach(franquiciaEntity -> {
            FranquiciaDTO franquiciaDTO = mapper.toModel(franquiciaEntity);
            franquiciafins.add(franquiciaDTO);
        });
        return franquiciafins;
    }

    @Override
    public FranquiciaDTO findByNombre(String nombre) {
        Optional<FranquiciaEntity> optionalFranquiciaEntity = repository.findByNombreFranquicia(nombre);
        if (optionalFranquiciaEntity.isPresent()) {
            FranquiciaEntity FranquiciaEntity = optionalFranquiciaEntity.get();
            return mapper.toModel(FranquiciaEntity);
        } else {
            return null;
        }
    }
}
