package com.loicmaria.api.controller;


import com.loicmaria.api.model.Author;
import com.loicmaria.api.service.AuthorServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Optional;

@RequestMapping("/author")
@RestController
public class AuthorController {

    @Autowired
    AuthorServiceImpl authorService;

    /**
     * Create - Add a new author
     * @param author An object author
     * @return The author object saved
     */
    @PostMapping
    public Author createAuthor(@RequestBody Author author) {
        return authorService.save(author);
    }


    /**
     * Read - Get one author
     * @param id The id of the author
     * @return An Author object full filled
     */
    @GetMapping("/{id}")
    public Author getAuthor(@PathVariable("id") int id) {
        Optional<Author> author = authorService.get(id);
        if(author.isPresent()) {
            return author.get();
        } else {
            return null;
        }
    }

    /**
     * Read - Get all authors
     * @return - An Iterable object of Author full filled
     */
    @GetMapping("/authors")
    public Collection<Author> getAuthors() {
        return authorService.getter();
    }

    /**
     * Update - Update an existing author
     * @param id - The id of the author to update
     * @param author - The author object updated
     * @return The currentAuthor if he is present or null
     */
    @PutMapping("/{id}")
    public Author updateAuthor(@PathVariable("id")  int id, @RequestBody Author author) {
        Optional<Author> e = authorService.get(id);
        if(e.isPresent()) {
            Author currentAuthor = e.get();

            String firstName = author.getFirstName();
            if(firstName != null) {
                currentAuthor.setFirstName(firstName);
            }
            String lastName = author.getLastName();
            if(lastName != null) {
                currentAuthor.setLastName(lastName);
            }
            authorService.save(currentAuthor);
            return currentAuthor;
        } else {
            return null;
        }
    }


    /**
     * Delete - Delete an author
     * @param id - The id of the author to delete
     */
    @DeleteMapping("/{id}")
    public void deleteAuthor(@PathVariable("id")  int id) {
        authorService.delete(id);
    }
}
