package com.sgb.biblioteca.repositories;

import com.sgb.biblioteca.model.Libro;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LibroRepository extends R2dbcRepository<Libro, Long> {
}
