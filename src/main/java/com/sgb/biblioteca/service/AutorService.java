package com.sgb.biblioteca.service;

import com.sgb.biblioteca.model.Autor;
import com.sgb.biblioteca.repositories.AutorRepository;
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
public class AutorService {

    private final Logger LOGGER = LoggerFactory.getLogger(AutorService.class);


    private final AutorRepository autorRepository;

    public Flux<Autor> findAll() {
        return autorRepository.findAll()
                .onErrorResume(throwable -> {
                    LOGGER.error("Error al consultar todos los productos", throwable);
                    return Mono.empty();
                })
                .switchIfEmpty(Mono.error(new ResponseStatusException(HttpStatus.NOT_FOUND, "Ningún Autor encontrado")));
    }

    public Mono<Autor> findById(Long id) {
        return autorRepository.findById(id)
                .onErrorResume(throwable -> {
                    LOGGER.error("Error al consultar el autor con id= " + id, throwable);
                    return Mono.empty();
                })
                .switchIfEmpty(Mono.error(new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "Autor con id= " + id + " no encontrado")));
    }

    public Mono<Autor> save(Autor autor) {
        return autorRepository.save(autor)
                .onErrorResume(throwable -> {
                    LOGGER.error("Error al guardar un autor", throwable);
                    return Mono.empty();
                })
                .switchIfEmpty(Mono.error(new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "Autor no guardado")));
    }

    public Mono<Void> delete(Long id) {
        return autorRepository.deleteById(id)
                .onErrorResume(throwable -> {
                    LOGGER.error("Error al eliminar un autor", throwable);
                    return Mono.error(throwable);
                });
    }
}
