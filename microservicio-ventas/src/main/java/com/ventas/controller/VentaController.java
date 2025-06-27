package com.ventas.controller;

import com.ventas.model.Venta;
import com.ventas.service.VentaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ventas")
public class VentaController {

    // En tu Controller (ejemplo: VentasController.java)
@RestController
@RequestMapping("/api")
public class VentasController {

    @GetMapping("/ping")
    public String ping() {
        return "¡Microservicio funciona!";
    }
}


    private final VentaService ventaService;

    public VentaController(VentaService ventaService) {
        this.ventaService = ventaService;
    }

    // Endpoint para obtener todas las ventas
    @GetMapping
    public List<Venta> obtenerTodasLasVentas() {
        return ventaService.obtenerTodasLasVentas();
    }

    // Endpoint para obtener una venta por ID
    @GetMapping("/{id}")
    public ResponseEntity<Venta> obtenerVentaPorId(@PathVariable Long id) {
        return ventaService.obtenerVentaPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Endpoint para crear una venta
    @PostMapping
    public ResponseEntity<Venta> crearVenta(@RequestBody Venta venta) {
        Venta nuevaVenta = ventaService.guardarVenta(venta);
        return new ResponseEntity<>(nuevaVenta, HttpStatus.CREATED);
    }

    // Endpoint para actualizar una venta
    @PutMapping("/{id}")
    public ResponseEntity<Venta> actualizarVenta(@PathVariable Long id, @RequestBody Venta ventaActualizada) {
        return ventaService.obtenerVentaPorId(id)
                .map(venta -> {
                    venta.setIdCliente(ventaActualizada.getIdCliente());
                    venta.setFechaVenta(ventaActualizada.getFechaVenta());
                    venta.setMontoTotal(ventaActualizada.getMontoTotal());
                    Venta ventaGuardada = ventaService.guardarVenta(venta);
                    return new ResponseEntity<>(ventaGuardada, HttpStatus.OK);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    // Endpoint para eliminar una venta
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarVenta(@PathVariable Long id) {
        if (ventaService.obtenerVentaPorId(id).isPresent()) {
            ventaService.eliminarVenta(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
