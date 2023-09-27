package com.loicmaria.api.controller;


import com.loicmaria.api.DTO.AuthorDto;
import com.loicmaria.api.service.AuthorServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;


@RestController
@RequestMapping("/authors")
public class AuthorController {

    @Autowired
    AuthorServiceImpl authorService;


    /**
     * Create - Add a new author
     *
     * @param authorDto An object author
     * @return ResponseEntity.ok
     */
    @PostMapping("/create")
    public ResponseEntity<?> createAuthor(@RequestBody AuthorDto authorDto) {
        return ResponseEntity.ok(authorService.save(authorDto));
    }


    /**
     * Read - Get one author
     *
     * @param id The id of the author
     * @return An Author object full filled
     */
    @GetMapping("/id/{id}")
    public AuthorDto getAuthor(@PathVariable("id") int id) {
        AuthorDto authorDto = authorService.get(id);
        return authorDto;
    }

    /**
     * Read - Get all authors
     *
     * @return - An Iterable object of Author full filled
     */
    @GetMapping("/all")
    public Collection<AuthorDto> getAuthors() {
        return authorService.getter();
    }

    /**
     * Update - Update an existing author
     *
     * @param authorDto - The author object updated
     * @return The currentAuthor if he is present or null
     */
    @PutMapping("/update")
    public AuthorDto updateAuthor(@RequestBody AuthorDto authorDto) {
        authorService.save(authorDto);
        return authorDto;
    }


    /**
     * Delete - Delete an author
     *
     * @param id - The id of the author to delete
     */
    @DeleteMapping("/id/{id}")
    public void deleteAuthor(@PathVariable("id") int id) {
        authorService.delete(id);
    }
}
