package com.sgb.biblioteca.repositories;

import com.sgb.biblioteca.model.Autor;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AutorRepository extends ReactiveCrudRepository<Autor, Long> {

}