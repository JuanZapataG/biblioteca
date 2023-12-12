package com.sgb.biblioteca.controller;

import com.sgb.biblioteca.model.Autor;
import com.sgb.biblioteca.service.AutorService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/autores")
@AllArgsConstructor
public class AutorController {

    private final AutorService autorService;

    @GetMapping
    public Flux<Autor> getAllAutores() {
        return autorService.findAll();
    }

    @GetMapping("/{id}")
    public Mono<Autor> getAutorById(@PathVariable Long id) {
        return autorService.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<Autor> createAutor(@RequestBody Autor autor) {
        return autorService.save(autor);
    }

    @PutMapping("/{id}")
    public Mono<Autor> updateAutor(@PathVariable Long id, @RequestBody Autor autor) {
        return autorService.findById(id)
                .flatMap(existingAutor -> {
                    existingAutor.setNombre(autor.getNombre());
                    existingAutor.setNacionalidad(autor.getNacionalidad());
                    return autorService.save(existingAutor);
                });
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Mono<Void> deleteAutor(@PathVariable Long id) {
        return autorService.delete(id);
    }


}
