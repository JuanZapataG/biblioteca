package com.sgb.biblioteca.controller;

import com.sgb.biblioteca.model.Prestamo;
import com.sgb.biblioteca.service.PrestamoService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
@RestController
@RequestMapping("/prestamos")
@AllArgsConstructor
public class PrestamoController {

    private final PrestamoService prestamoService;

    @GetMapping
    public Flux<Prestamo> getAllPrestamos() {
        return prestamoService.findAll();
    }

    @GetMapping("/{id}")
    public Mono<Prestamo> getPrestamoById(@PathVariable Long id) {
        return prestamoService.findById(id);
    }
}
