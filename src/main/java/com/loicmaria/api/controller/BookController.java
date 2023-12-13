package com.loicmaria.api.controller;


import com.loicmaria.api.DTO.BookDto;
import com.loicmaria.api.service.BookServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;


@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    BookServiceImpl bookService;

    //      CRUD Operations
    //----------------------------------------------------------------------------------------------------------------

    @PostMapping
    public ResponseEntity<?> createBook(@RequestBody BookDto bookDto) {
        BookDto createdBook = bookService.save(bookDto);

        if (createdBook != null){
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(createdBook);
        } else {
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Erreur lors de la création de l'utilisateur.");
        }
    }

    @GetMapping("/{id}")
    public BookDto getBook(@PathVariable int id) {
        return bookService.get(id);
    }

    @GetMapping
    public Collection<BookDto> getBooks() {
        return bookService.getter();
    }

    @PutMapping("/{id}")
    public ResponseEntity<BookDto> updateBook(
            @PathVariable int id,
            @RequestBody BookDto bookDto) {

        if (id != bookDto.getId()) {
            return ResponseEntity.badRequest().build();
        }
        bookService.save(bookDto);
        return ResponseEntity.ok(bookDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable int id) {
        boolean bookExists = bookService.exists(id);

        if (bookExists){
            bookService.delete(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    //----------------------------------------------------------------------------------------------------------------

    @GetMapping("/title/{title}")
    public Collection<BookDto> getBooksBySearch(@PathVariable String title){
     return bookService.findByTitle(title);
    }
}
