package com.sgb.biblioteca.service;

import com.sgb.biblioteca.model.Libro;
import com.sgb.biblioteca.repositories.LibroRepository;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@AllArgsConstructor
public class LibroService {

    private  final Logger LOGGER = LoggerFactory.getLogger(LibroService.class);
    private final LibroRepository libroRepository;

    public Flux<Libro> findAll() {
        return libroRepository.findAll()
                .onErrorResume(throwable -> {
                    LOGGER.error("Error al consultar todos los libros", throwable);
                    return Flux.empty();
                })
                .switchIfEmpty(Mono.error(new ResponseStatusException(HttpStatus.NOT_FOUND, "Ningún Libro encontrado")));
    }

    public Mono<Libro> findById(Long id) {
        return libroRepository.findById(id)
                .onErrorResume(throwable -> {
                    LOGGER.error("Error al consultar el libro con id= " + id, throwable);
                    return Mono.empty();
                })
                .switchIfEmpty(Mono.error(new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "Libro con id= " + id + " no encontrado")));
    }
}
