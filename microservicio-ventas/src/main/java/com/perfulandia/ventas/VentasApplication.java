package com.perfulandia.ventas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// Esta clase es el punto de entrada para el microservicio de ventas
@SpringBootApplication
public class VentasApplication {

    public static void main(String[] args) {
        SpringApplication.run(VentasApplication.class, args);
    }

}
