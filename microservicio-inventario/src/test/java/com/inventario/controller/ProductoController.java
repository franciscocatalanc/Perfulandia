package com.inventario.controller;

import com.inventario.model.Producto;
import com.inventario.service.ProductoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/productos")
@Tag(name = "Productos", description = "Operaciones de gestión de productos")
public class ProductoController {

    @Autowired
    private ProductoService productoService;

    @Operation(summary = "Listar productos", description = "Devuelve una lista de todos los productos")
    @GetMapping
    public List<Producto> listarProductos() {
        return productoService.listarTodos();
    }

    @Operation(summary = "Obtener producto por ID", description = "Devuelve un producto específico por su ID con enlaces HATEOAS")
    @GetMapping("/{id}")
    public ResponseEntity<EntityModel<Producto>> obtenerProductoPorId(@PathVariable Long id) {
        Producto producto = productoService.obtenerPorId(id);
        if (producto != null) {
            EntityModel<Producto> recurso = EntityModel.of(producto);

            recurso.add(linkTo(methodOn(ProductoController.class).obtenerProductoPorId(id)).withSelfRel());
            recurso.add(linkTo(methodOn(ProductoController.class).listarProductos()).withRel("todos"));
            recurso.add(linkTo(methodOn(ProductoController.class).eliminarProducto(id)).withRel("eliminar"));

            return ResponseEntity.ok(recurso);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @Operation(summary = "Crear nuevo producto", description = "Registra un nuevo producto en la base de datos")
    @PostMapping
    public Producto crearProducto(@RequestBody Producto producto) {
        return productoService.guardarProducto(producto);
    }

    @Operation(summary = "Actualizar producto", description = "Actualiza un producto existente por su ID")
    @PutMapping("/{id}")
    public ResponseEntity<Producto> actualizarProducto(@PathVariable Long id, @RequestBody Producto productoDetalles) {
        Producto productoActualizado = productoService.actualizarProducto(id, productoDetalles);
        if (productoActualizado != null) {
            return ResponseEntity.ok(productoActualizado);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @Operation(summary = "Eliminar producto", description = "Elimina un producto existente por su ID")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarProducto(@PathVariable Long id) {
        boolean eliminado = productoService.eliminarProducto(id);
        if (eliminado) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
