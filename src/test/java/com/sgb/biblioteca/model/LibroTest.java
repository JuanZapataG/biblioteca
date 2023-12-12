package com.sgb.biblioteca.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LibroTest {

    @Test
    void calcularCostoTotal() {
        Libro libro = new Libro();
        libro.setPrecioBase(100.0);
        Integer pesoEmpaque = 200;
        Double costoEsperado = libro.getPrecioBase() + pesoEmpaque;
        assertEquals(costoEsperado, libro.calcularCostoTotal());
    }

    @Test
    void calcularPesoTotal() {
        Libro libro = new Libro();
        libro.setPesoNeto(500.0);
        libro.setPrecioBase(100.0);
        Double impuesto = 0.1 * libro.getPrecioBase();
        Double pesoEsperado = libro.getPesoNeto() + impuesto;
        assertEquals(pesoEsperado, libro.calcularPesoTotal());
    }

}