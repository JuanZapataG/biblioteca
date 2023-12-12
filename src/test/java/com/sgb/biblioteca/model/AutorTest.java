package com.sgb.biblioteca.model;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

import static org.junit.jupiter.api.Assertions.*;

class AutorTest {
    @Test
    void calcularEdadAutorVivo() {
        Autor autor = new Autor();
        autor.setFechaNacimiento("01/01/1980"); // Fecha de nacimiento

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate birthDate = LocalDate.parse("01/01/1980", formatter);
        int expectedAge = LocalDate.now().getYear() - birthDate.getYear();
         assertEquals(expectedAge + " años", autor.calcularCostoTotal());
    }

    @Test
    void calcularEdadAutorFallecido() {

        Autor autor = new Autor();
        autor.setFechaNacimiento("01/01/1950");
        autor.setFechaDefuncion("01/01/2000"); // Fecha de defunción

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate birthDate = LocalDate.parse("01/01/1950", formatter);
        LocalDate deathDate = LocalDate.parse("01/01/2000", formatter);
        int expectedAge = Period.between(birthDate, deathDate).getYears();

        assertEquals(expectedAge + " años", autor.calcularCostoTotal());
    }

}