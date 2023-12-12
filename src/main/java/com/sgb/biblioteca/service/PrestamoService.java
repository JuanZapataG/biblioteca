package com.sgb.biblioteca.service;

import com.sgb.biblioteca.model.Prestamo;
import com.sgb.biblioteca.repositories.PrestamoRepository;
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
public class PrestamoService {

    private final Logger LOGGER = LoggerFactory.getLogger(PrestamoService.class);
    private final PrestamoRepository prestamoRepository;

    public Flux<Prestamo> findAll() {
        return prestamoRepository.findAll()
                .onErrorResume(throwable -> {
                    LOGGER.error("Error al consultar todos los préstamos", throwable);
                    return Flux.empty();
                })
                .switchIfEmpty(Mono.error(new ResponseStatusException(HttpStatus.NOT_FOUND, "Ningún Préstamo encontrado")));
    }

    public Mono<Prestamo> findById(Long id) {
        return prestamoRepository.findById(id)
                .onErrorResume(throwable -> {
                    LOGGER.error("Error al consultar el préstamo con id= " + id, throwable);
                    return Mono.empty();
                })
                .switchIfEmpty(Mono.error(new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "Préstamo con id= " + id + " no encontrado")));
    }
}
