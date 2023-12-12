package com.sgb.biblioteca.model;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static org.junit.jupiter.api.Assertions.*;

class UsuarioTest {

    @Test
    void calcularEdadUsuario() {

        Usuario usuario = new Usuario();
        usuario.setFechaNacimiento("01/01/1980");

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate birthDate = LocalDate.parse("01/01/1980", formatter);
        int expectedAge = LocalDate.now().getYear() - birthDate.getYear();

        assertEquals(expectedAge + " años", usuario.calcularCostoTotal());
    }

}