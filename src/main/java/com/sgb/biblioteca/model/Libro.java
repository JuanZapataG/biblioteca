package com.sgb.biblioteca.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table("libros")
public class Libro implements CalculablePeso, CalculableCosto{

    @Id
    private Long id;
    private String titulo;
    private String isbn;
    private Long autorId;
    private Double pesoNeto;
    private Double precioBase;
    private String editorial;


    @Override
    public Double calcularCostoTotal() {
        Integer pesoEmpaque = 200;
        return this.precioBase + pesoEmpaque;
    }

    @Override
    public Double calcularPesoTotal() {
        Double impuesto = 0.1 * precioBase;
        return this.pesoNeto + impuesto;
    }
}
