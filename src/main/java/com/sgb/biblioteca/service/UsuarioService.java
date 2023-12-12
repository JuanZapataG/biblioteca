package com.sgb.biblioteca.service;

import com.sgb.biblioteca.model.Usuario;
import com.sgb.biblioteca.repositories.UsuarioRepository;
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
public class UsuarioService {

    private final Logger LOGGER = LoggerFactory.getLogger(UsuarioService.class);
    private final UsuarioRepository usuarioRepository;

    public Flux<Usuario> findAll() {
        return usuarioRepository.findAll()
                .onErrorResume(throwable -> {
                    LOGGER.error("Error al consultar todos los usuarios", throwable);
                    return Flux.empty();
                })
                .switchIfEmpty(Mono.error(new ResponseStatusException(HttpStatus.NOT_FOUND, "Ningún Usuario encontrado")));
    }

    public Mono<Usuario> findById(Long id) {
        return usuarioRepository.findById(id)
                .onErrorResume(throwable -> {
                    LOGGER.error("Error al consultar el usuario con id= " + id, throwable);
                    return Mono.empty();
                })
                .switchIfEmpty(Mono.error(new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "Usuario con id= " + id + " no encontrado")));
    }
}
