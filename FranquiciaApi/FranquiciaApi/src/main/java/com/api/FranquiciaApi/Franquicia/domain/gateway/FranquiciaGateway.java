package com.api.FranquiciaApi.Franquicia.domain.gateway;


import com.api.FranquiciaApi.Franquicia.domain.model.FranquiciaDTO;

import java.util.List;

public interface FranquiciaGateway {

    FranquiciaDTO save(FranquiciaDTO franquiciaDTO);

    void delete(Integer id);

    FranquiciaDTO update(FranquiciaDTO franquiciaDTO);

    FranquiciaDTO findById(Integer id);

    FranquiciaDTO findByNombre(String nombre);

    List<FranquiciaDTO> getFranquicias();
}
