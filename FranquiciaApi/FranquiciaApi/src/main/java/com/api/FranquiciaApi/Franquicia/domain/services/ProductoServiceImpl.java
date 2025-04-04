package com.api.FranquiciaApi.Franquicia.domain.services;

import com.api.FranquiciaApi.Franquicia.domain.model.ProductoDTO;
import com.api.FranquiciaApi.Franquicia.domain.model.SucursalDTO;
import com.api.FranquiciaApi.Franquicia.infraestructure.drivenadapter.mysql.ProductoRepository;
import com.api.FranquiciaApi.Franquicia.infraestructure.drivenadapter.mysql.SucursalRepository;
import com.api.FranquiciaApi.Franquicia.infraestructure.drivenadapter.mysql.mapper.ProductoMapper;
import com.api.FranquiciaApi.Franquicia.infraestructure.drivenadapter.mysql.model.ProductoEntity;
import com.api.FranquiciaApi.Franquicia.infraestructure.drivenadapter.mysql.model.SucursalEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductoServiceImpl implements ProductoService{
    private final ProductoRepository productoRepository;
    private final SucursalRepository sucursalRepository;
    private  final ProductoMapper productoMapper;

    public ProductoServiceImpl(ProductoRepository productoRepository, SucursalRepository sucursalRepository,ProductoMapper productoMapper) {
        this.productoRepository = productoRepository;
        this.sucursalRepository = sucursalRepository;
        this.productoMapper = productoMapper;
    }

    @Override
    public ProductoDTO agregarProducto(Integer franquiciaId, Integer sucursalId, ProductoDTO producto) {
        Optional<SucursalEntity> sucursal = sucursalRepository.findById(sucursalId);
        if (sucursal.isPresent()) {
            producto.setId(sucursal.get().getId());
            productoRepository.save(productoMapper.toEntity(producto));
            return producto;
        }
        throw new RuntimeException("Sucursal no encontrada");
    }

    @Override
    public void eliminarProducto(Integer franquiciaId, Integer sucursalId, Integer productoId) {
        productoRepository.deleteById(productoId);
    }

    @Override
    public ProductoDTO modificarStock(Integer franquiciaId, Integer sucursalId, Integer productoId, Integer stock) {
        Optional<ProductoEntity> producto = productoRepository.findById(productoId);
        if (producto.isPresent()) {
            ProductoEntity p = producto.get();
            p.setStock(stock);
            productoRepository.save(p);
            return productoMapper.toModel(p);
        }
        throw new RuntimeException("Producto no encontrado");
    }

    @Override
    public ProductoDTO actualizarNombreProducto(Integer franquiciaId, Integer sucursalId, Integer productoId, String nombre) {
        Optional<ProductoEntity> producto = productoRepository.findById(productoId);
        if (producto.isPresent()) {
            ProductoEntity p = producto.get();
            p.setNombre(nombre);
            productoRepository.save(p);
            return productoMapper.toModel(p);
        }
        throw new RuntimeException("Producto no encontrado");
    }

    @Override
    public List<ProductoDTO> obtenerProductosMaxStock(Integer franquiciaId, Integer sucursalId) {
        SucursalEntity sucursal = sucursalRepository.findById(sucursalId)
                .orElseThrow(() -> new IllegalArgumentException("La sucursal no existe."));

        if (!sucursal.getFranquicia().equals(franquiciaId)) {
            throw new IllegalArgumentException("La sucursal no pertenece a la franquicia proporcionada.");
        }

        List<ProductoEntity> productos = productoRepository.findMaxStockBySucursal(sucursalId);
        if (productos.isEmpty()) {
            return Collections.emptyList();
        }

        int maxStock = productos.get(0).getStock();

        return productos.stream()
                .filter(p -> p.getStock() == maxStock)
                .map(productoMapper::toModel)
                .collect(Collectors.toList());
    }

}
