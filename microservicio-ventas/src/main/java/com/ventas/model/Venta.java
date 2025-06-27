package com.ventas.model;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Column;

import java.time.LocalDate;

@Entity
public class Venta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;  // ID único autogenerado

    @Column(nullable = false)
    private Long idCliente;  // ID del cliente que realiza la compra

    @Column(nullable = false)
    private LocalDate fechaVenta;  // Fecha de la venta

    @Column(nullable = false)
    private Double montoTotal;  // Monto total de la venta

    // Constructor vacío (requerido por JPA)
    public Venta() {}

    // Constructor con parámetros
    public Venta(Long idCliente, LocalDate fechaVenta, Double montoTotal) {
        this.idCliente = idCliente;
        this.fechaVenta = fechaVenta;
        this.montoTotal = montoTotal;
    }

    // Getters y setters
    public Long getId() {
        return id;
    }

    public Long getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Long idCliente) {
        this.idCliente = idCliente;
    }

    public LocalDate getFechaVenta() {
        return fechaVenta;
    }

    public void setFechaVenta(LocalDate fechaVenta) {
        this.fechaVenta = fechaVenta;
    }

    public Double getMontoTotal() {
        return montoTotal;
    }

    public void setMontoTotal(Double montoTotal) {
        this.montoTotal = montoTotal;
    }
}
