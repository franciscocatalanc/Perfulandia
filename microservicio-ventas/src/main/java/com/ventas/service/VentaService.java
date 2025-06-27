package com.ventas.service;

import com.ventas.repository.VentaRepository;


import com.ventas.model.Venta;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VentaService {

    private final VentaRepository ventaRepository;

    public VentaService(VentaRepository ventaRepository) {
        this.ventaRepository = ventaRepository;
    }

    // Obtener todas las ventas
    public List<Venta> obtenerTodasLasVentas() {
        return ventaRepository.findAll();
    }

    // Buscar una venta por ID
    public Optional<Venta> obtenerVentaPorId(Long id) {
        return ventaRepository.findById(id);
    }

    // Crear o actualizar una venta
    public Venta guardarVenta(Venta venta) {
        return ventaRepository.save(venta);
    }

    // Eliminar una venta por ID
    public void eliminarVenta(Long id) {
        ventaRepository.deleteById(id);
    }
}
