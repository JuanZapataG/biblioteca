package com.sgb.biblioteca.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table("prestamos")
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
