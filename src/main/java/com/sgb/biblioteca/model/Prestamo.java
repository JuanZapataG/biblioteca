package com.sgb.biblioteca.model;

import org.springframework.data.annotation.Id;

public class Prestamo  implements CalculableDuracionPrestamo{
    @Id
    private Long id;
    private Long usuarioId;
    private Long libroId;
    private String fechaPrestamo;
    private String fechaDevolucion;

    @Override
    public Integer calcularDiasPrestamo(Integer numeroPeriodos) {
        Integer duracionPeriodo = 7;
        return numeroPeriodos * duracionPeriodo;
    }
}
