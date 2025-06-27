package com.ventas.repository;


import com.ventas.model.Venta;
import com.ventas.repository.VentaRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VentaRepository extends JpaRepository<Venta, Long> {
    // Aquí puedes agregar métodos de consulta personalizados si los necesitas
}
