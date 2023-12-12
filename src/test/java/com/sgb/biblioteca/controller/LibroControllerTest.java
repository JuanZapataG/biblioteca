package com.sgb.biblioteca.controller;


import com.sgb.biblioteca.model.Libro;
import com.sgb.biblioteca.service.LibroService;
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

import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
class LibroControllerTest {

    @Mock
    private LibroService libroService;

    @InjectMocks
    private LibroController libroController;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetAll() {
        Libro libro1 = new Libro(1L, "El principito", "2020", 1L, 23432D, 2342D, "LaFicción");
        Libro libro2 = new Libro(2L, "El principito2", "2023", 1L, 23432D, 2342D, "LaFicción");
        Flux<Libro> librosEsperados = Flux.just(libro1, libro2);
        when(libroService.findAll()).thenReturn(librosEsperados);

        StepVerifier.create(libroController.getAllLibros())
                .expectNext(libro1)
                .expectNext(libro2)
                .expectComplete()
                .verify();
    }

    @Test
    void testGetById() {
        Libro libroEsperado = new Libro(1L, "El principito", "2020", 1L, 23432D, 2342D, "LaFicción");
        when(libroService.findById(1L)).thenReturn(Mono.just(libroEsperado));

        StepVerifier.create(libroController.getLibroById(1L))
                .expectNext(libroEsperado)
                .expectComplete()
                .verify();
    }
}