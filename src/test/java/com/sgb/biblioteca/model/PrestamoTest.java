package com.sgb.biblioteca.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PrestamoTest {
    @Test
    void calcularDiasPrestamo() {

        Prestamo prestamo = new Prestamo();

        Integer numeroPeriodos = 3;
        Integer duracionPeriodo = 7;
        Integer diasEsperados = numeroPeriodos * duracionPeriodo;
        assertEquals(diasEsperados, prestamo.calcularDiasPrestamo(numeroPeriodos));
    }

}