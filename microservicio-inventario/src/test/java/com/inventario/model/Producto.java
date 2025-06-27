package com.inventario.model;

import jakarta.persistence.*;


@Entity

@Table(name = "productos")
public class Producto {

    // Clave primaria autogenerada
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Nombre del producto (no nulo)
    @Column(nullable = false)
    private String nombre;

    // Descripción del producto
    private String descripcion;

    // Precio del producto (no nulo)
    @Column(nullable = false)
    private Double precio;

    // Stock disponible
    private Integer stock;

    // Constructor vacío obligatorio para JPA
    public Producto() {
    }

    // Constructor con todos los campos (excepto id que es autogenerado)
    public Producto(String nombre, String descripcion, Double precio, Integer stock) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.stock = stock;
    }

    // Getters y setters para cada campo

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }
}
