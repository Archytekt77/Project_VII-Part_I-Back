package com.loicmaria.api.controller;


import com.loicmaria.api.DTO.AuthorDto;
import com.loicmaria.api.service.AuthorServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;


@RestController
@RequestMapping("/authors")
public class AuthorController {

    @Autowired
    AuthorServiceImpl authorService;

    //      CRUD Operations
    //----------------------------------------------------------------------------------------------------------------

    @PostMapping
    public ResponseEntity<?> createAuthor(@RequestBody AuthorDto authorDto) {
        AuthorDto createdAuthor = authorService.save(authorDto);

        if (createdAuthor != null) {
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(createdAuthor);
        } else {
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Erreur lors de la création de l'auteur.");
        }
    }

    @GetMapping("/{id}")
    public AuthorDto getAuthor(@PathVariable int id) {
        return authorService.get(id);
    }

    @GetMapping
    public Collection<AuthorDto> getAuthors() {
        return authorService.getter();
    }

    @PutMapping("/{id}")
    public ResponseEntity<AuthorDto> updateAuthor(
            @PathVariable int id,
            @RequestBody AuthorDto authorDto) {
        
        if (id != authorDto.getId()) {
            return ResponseEntity.badRequest().build();
        }
        authorService.save(authorDto);
        return ResponseEntity.ok(authorDto);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAuthor(@PathVariable int id) {
        boolean authorExists = authorService.exists(id);

        if (authorExists){
            authorService.delete(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
