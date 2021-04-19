package com.loicmaria.api.controller;


import com.loicmaria.api.DTO.AuthorDto;
import com.loicmaria.api.service.AuthorServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RequestMapping("/authors")
@RestController
public class AuthorController {

    @Autowired
    AuthorServiceImpl authorService;

    /**
     * Create - Add a new author
     *
     * @param authorDto An object author
     * @return The author object saved
     */
    @PostMapping
    public AuthorDto createAuthor(@RequestBody AuthorDto authorDto) {
        return authorService.save(authorDto);
    }


    /**
     * Read - Get one author
     *
     * @param id The id of the author
     * @return An Author object full filled
     */
    @GetMapping("/{id}")
    public AuthorDto getAuthor(@PathVariable("id") int id) {
        AuthorDto authorDto = authorService.get(id);
        return authorDto;
    }

    /**
     * Read - Get all authors
     *
     * @return - An Iterable object of Author full filled
     */
    @GetMapping
    public Collection<AuthorDto> getAuthors() {
        return authorService.getter();
    }

    /**
     * Update - Update an existing author
     *
     * @param id     - The id of the author to update
     * @param authorDto - The author object updated
     * @return The currentAuthor if he is present or null
     */
    @PutMapping("/{id}")
    public AuthorDto updateAuthor(@PathVariable("id") int id, @RequestBody AuthorDto authorDto) {
        authorService.save(authorDto);
        return authorDto;
    }


    /**
     * Delete - Delete an author
     *
     * @param id - The id of the author to delete
     */
    @DeleteMapping("/{id}")
    public void deleteAuthor(@PathVariable("id") int id) {
        authorService.delete(id);
    }
}
