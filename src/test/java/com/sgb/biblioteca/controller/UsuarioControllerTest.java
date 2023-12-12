package com.sgb.biblioteca.controller;

import com.sgb.biblioteca.model.Usuario;
import com.sgb.biblioteca.service.UsuarioService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.junit4.SpringRunner;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
class UsuarioControllerTest {

    @Mock
    private UsuarioService usuarioService;

    @InjectMocks
    private UsuarioController usuarioController;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void getAllUsuarios() {
        Usuario usuario1 = new Usuario(1L, "Gabriel", "Colombiana", "06/03/2023", "06/03/2023");
        Usuario usuario2 = new Usuario(2L, "Juan", "Británica", "31/07/2023", "31/07/2023");
        Flux<Usuario> usuariosEsperados = Flux.just(usuario1, usuario2);
        when(usuarioService.findAll()).thenReturn(usuariosEsperados);

        StepVerifier.create(usuarioController.getAllUsuarios())
                .expectNext(usuario1)
                .expectNext(usuario2)
                .expectComplete()
                .verify();
    }

    @Test
    void testGetUsuarioById() {
        Usuario usuarioEsperado = new Usuario(1L, "Gabriel", "Colombiana", "06/03/2023", "06/03/2023");
        when(usuarioService.findById(1L)).thenReturn(Mono.just(usuarioEsperado));

        StepVerifier.create(usuarioController.getUsuarioById(1L))
                .expectNext(usuarioEsperado)
                .expectComplete()
                .verify();
    }


}