package com.sgb.biblioteca.controller;

import com.sgb.biblioteca.model.Prestamo;
import com.sgb.biblioteca.service.PrestamoService;
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
class PrestamoControllerTest {

    @Mock
    private PrestamoService prestamoService;
    @InjectMocks
    private PrestamoController prestamoController;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetAll() {
        Prestamo prestamo1 = new Prestamo(1L, 1L, 1L, "06/03/2023","06/03/2023");
        Prestamo prestamo2 = new Prestamo(2L, 2L, 2L, "06/03/2023","06/03/2023");
        Flux<Prestamo> prestamosEsperados = Flux.just(prestamo1, prestamo2);
        when(prestamoService.findAll()).thenReturn(prestamosEsperados);
        StepVerifier.create(prestamoController.getAllPrestamos())
                .expectNext(prestamo1)
                .expectNext(prestamo2)
                .expectComplete()
                .verify();

    }

    @Test
    void testGetById() {
        Prestamo prestamoEsperado = new Prestamo(1L, 1L, 1L, "06/03/2023","06/03/2023");
        when(prestamoService.findById(1L)).thenReturn(Mono.just(prestamoEsperado));
        StepVerifier.create(prestamoController.getPrestamoById(1L))
                .expectNext(prestamoEsperado)
                .expectComplete()
                .verify();
    }


}