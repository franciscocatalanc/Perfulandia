package com.inventario.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class inventarioController {

    @GetMapping("/inventario")
    public String inventarioString() {
        return "el inventario esta siendo actualizado";
    }
}
