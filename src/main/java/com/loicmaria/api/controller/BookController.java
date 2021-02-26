package com.loicmaria.api.controller;

import com.loicmaria.api.model.Book;
import com.loicmaria.api.service.BookServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.Optional;

@RestController
@RequestMapping("/book")
public class BookController {

    @Autowired
    BookServiceImpl bookService;

    /**
     * Create - Add a new book
     *
     * @param book An object book
     * @return The book object saved
     */
    @PostMapping("/book")
    public Book createBook(@RequestBody Book book) {
        return bookService.save(book);
    }


    /**
     * Read - Get one book 
     * @param id The id of the book
     * @return An Book object full filled
     */
    @GetMapping("/{id}")
    public Book getBook(@PathVariable("id")  int id) {
        Optional<Book> book = bookService.get(id);
        if(book.isPresent()) {
            return book.get();
        } else {
            return null;
        }
    }

    /**
     * Read - Get all books
     * @return - An Iterable object of Book full filled
     */
    @GetMapping("/books")
    public Iterable<Book> getBooks() {
        return bookService.getter();
    }

    /**
     * Update - Update an existing book
     * @param id - The id of the book to update
     * @param book - The book object updated
     * @return The currentBook if he is present or null
     */
    @PutMapping("/{id}")
    public Book updateBook(@PathVariable("id")  int id, @RequestBody Book book) {
        Optional<Book> e = bookService.get(id);
        if(e.isPresent()) {
            Book currentBook = e.get();

            String title = book.getTitle();
            if(title != null) {
                currentBook.setTitle(title);
            }
            String collection = book.getCollection();
            if(collection != null) {
                currentBook.setCollection(collection);;
            }
            String summary = book.getSummary();
            if(summary != null) {
                currentBook.setSummary(summary);
            }
            String language = book.getLanguage();
            if(language != null) {
                currentBook.setLanguage(language);;
            }
            Date publication  = book.getPublication();
            if (publication != null){
                currentBook.setPublication(publication);
            }
            bookService.save(currentBook);
            return currentBook;
        } else {
            return null;
        }
    }


    /**
     * Delete - Delete an book
     * @param id - The id of the book to delete
     */
    @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable("id")  int id) {
        bookService.delete(id);
    }
}
