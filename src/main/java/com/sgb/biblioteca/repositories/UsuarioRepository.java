package com.sgb.biblioteca.repositories;

import com.sgb.biblioteca.model.Usuario;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface UsuarioRepository extends ReactiveCrudRepository<Usuario, Long> {

}

