package com.sgb.biblioteca.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table("autores")
public class Autor implements CalculableEdad{
    @Id
    private Long id;
    private String nombre;
    private String nacionalidad;
    @Column("fechanacimiento")
    private String fechaNacimiento;
    @Column("fechadefuncion")
    private String fechaDefuncion;

    @Override
    public String calcularCostoTotal() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate birthDate = LocalDate.parse(this.fechaNacimiento, formatter);

        LocalDate endDate;
        if (this.fechaDefuncion != null) {
            endDate = LocalDate.parse(this.fechaDefuncion, formatter);
        } else {
            endDate = LocalDate.now();
        }

        int years = Period.between(birthDate, endDate).getYears();
        return years + " años";
    }
}
