package com.sgb.biblioteca.controller;

import com.sgb.biblioteca.model.Autor;
import com.sgb.biblioteca.service.AutorService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
class AutorControllerTest {

    @Mock
    private AutorService autorService;

    @InjectMocks
    private AutorController autorController;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetAllAutores() {
        Autor autor1 = new Autor(1L, "Gabriel", "Colombiana", "06/03/2023", "06/03/2023");
        Autor autor2 = new Autor(2L, "Juan", "Británica", "31/07/2023", "31/07/2023");
        Flux<Autor> autoresEsperados = Flux.just(autor1, autor2);
        when(autorService.findAll()).thenReturn(autoresEsperados);

        StepVerifier.create(autorController.getAllAutores())
                .expectNext(autor1)
                .expectNext(autor2)
                .expectComplete()
                .verify();
    }

    @Test
    void testGetAutorById() {
        Autor autorEsperado = new Autor(1L, "Gabriel", "Colombiana", "06/03/2023", "06/03/2023");
        when(autorService.findById(1L)).thenReturn(Mono.just(autorEsperado));

        StepVerifier.create(autorController.getAutorById(1L))
                .expectNext(autorEsperado)
                .expectComplete()
                .verify();
    }

    @Test
    void testCreateAutor() {
        Autor autorNuevo = new Autor(null, "Isabel", "Chilena", "02/08/2023", "02/08/2023");
        Autor autorGuardado = new Autor(3L, "Isabel", "Chilena", "02/08/2023", "02/08/2023");
        when(autorService.save(any(Autor.class))).thenReturn(Mono.just(autorGuardado));

        StepVerifier.create(autorController.createAutor(autorNuevo))
                .expectNext(autorGuardado)
                .expectComplete()
                .verify();
    }

    @Test
    void testUpdateAutor() {
        Autor autorExistente = new Autor(1L, "Gabriel", "Colombiana", "06/03/2023", "06/03/2023");
        Autor autorActualizado = new Autor(1L, "Gabriel", "Mexicana", "06/03/2023", "06/03/2023");
        when(autorService.findById(1L)).thenReturn(Mono.just(autorExistente));
        when(autorService.save(any(Autor.class))).thenReturn(Mono.just(autorActualizado));

        StepVerifier.create(autorController.updateAutor(1L, autorActualizado))
                .expectNext(autorActualizado)
                .expectComplete()
                .verify();
    }

    @Test
    void testDeleteAutor() {
        when(autorService.delete(1L)).thenReturn(Mono.empty());

        StepVerifier.create(autorController.deleteAutor(1L))
                .expectComplete()
                .verify();
    }
}