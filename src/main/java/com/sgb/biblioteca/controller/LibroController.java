package com.sgb.biblioteca.controller;

import com.sgb.biblioteca.model.Libro;
import com.sgb.biblioteca.service.LibroService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/libros")
@AllArgsConstructor
public class LibroController {

    private final LibroService libroService;

    @GetMapping
    public Flux<Libro> getAllLibros() {
        return libroService.findAll();
    }

    @GetMapping("/{id}")
    public Mono<Libro> getLibroById(@PathVariable Long id) {
        return libroService.findById(id);
    }

}
