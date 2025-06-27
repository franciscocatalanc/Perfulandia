package com.inventario.service;

import com.inventario.model.Producto;
import com.inventario.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@Service
public class ProductoServiceTest {

    @Autowired
    private ProductoRepository productoRepository;

    @Test
    // Listar todos los productos
    public List<Producto> listarTodos() {
        return productoRepository.findAll();
    }

    @Test
    // Obtener un producto por su ID
    public Producto obtenerPorId(Long id) {
        Optional<Producto> producto = productoRepository.findById(id);
        return producto.orElse(null);
    }

    @Test
    // Guardar un nuevo producto
    public Producto guardarProducto(Producto producto) {
        return productoRepository.save(producto);
    }

    @Test
    // Actualizar un producto existente
    public Producto actualizarProducto(Long id, Producto productoDetalles) {
        Optional<Producto> productoOptional = productoRepository.findById(id);
        if (productoOptional.isPresent()) {
            Producto producto = productoOptional.get();
            producto.setNombre(productoDetalles.getNombre());
            producto.setDescripcion(productoDetalles.getDescripcion());
            producto.setPrecio(productoDetalles.getPrecio());
            producto.setStock(productoDetalles.getStock());
            return productoRepository.save(producto);
        } else {
            return null;
        }
    }

    @Test
    // Eliminar un producto por ID
    public boolean eliminarProducto(Long id) {
        Optional<Producto> productoOptional = productoRepository.findById(id);
        if (productoOptional.isPresent()) {
            productoRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }

     






}
