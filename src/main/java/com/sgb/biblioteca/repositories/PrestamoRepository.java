package com.sgb.biblioteca.repositories;

import com.sgb.biblioteca.model.Prestamo;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface PrestamoRepository extends ReactiveCrudRepository<Prestamo, Long> {
}