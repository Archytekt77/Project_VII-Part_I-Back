package com.loicmaria.api.controller;

import com.loicmaria.api.DTO.BookDto;
import com.loicmaria.api.service.BookServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    BookServiceImpl bookService;

    /**
     * Create - Add a new book
     *
     * @param bookDto An object book
     * @return The book object saved
     */
    @PostMapping
    public BookDto createBook(@RequestBody BookDto bookDto) {
        return bookService.save(bookDto);
    }


    /**
     * Read - Get one book
     *
     * @param id The id of the book
     * @return An Book object full filled
     */
    @GetMapping("/{id}")
    public BookDto getBook(@PathVariable("id") int id) {
        BookDto bookDto = bookService.get(id);
        return bookDto;
    }

    /**
     * Read - Get all books
     *
     * @return - An Iterable object of Book full filled
     */
    @GetMapping
    public Collection<BookDto> getBooks() {
        return bookService.getter();
    }

    /**
     * Update - Update an existing book
     *
     * @param id   - The id of the book to update
     * @param bookDto - The book object updated
     * @return The currentBook if he is present or null
     */
    @PutMapping("/{id}")
    public BookDto updateBook(@PathVariable("id") int id, @RequestBody BookDto bookDto) {
        bookService.save(bookDto);
        return bookDto;
    }


    /**
     * Delete - Delete an book
     *
     * @param id - The id of the book to delete
     */
    @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable("id") int id) {
        bookService.delete(id);
    }
}
