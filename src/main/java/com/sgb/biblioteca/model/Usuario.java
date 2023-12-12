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
@Table("usuarios")
public class Usuario implements CalculableEdad{
    @Id
    private Long id;
    private String nombre;
    private String email;
    private String estado;
    @Column("fechanacimiento")
    private String fechaNacimiento;

    @Override
    public String calcularCostoTotal() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate birthDate = LocalDate.parse(this.fechaNacimiento, formatter);
        LocalDate currentDate = LocalDate.now();
        int years = Period.between(birthDate, currentDate).getYears();
        return years + " años";
        }

}
