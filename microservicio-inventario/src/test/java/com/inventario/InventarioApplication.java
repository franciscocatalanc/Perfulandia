package com.inventario;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// Clase principal para arrancar el microservicio inventario
@SpringBootApplication
public class InventarioApplication {

    public static void main(String[] args) {
        SpringApplication.run(InventarioApplication.class, args);
    }
}
