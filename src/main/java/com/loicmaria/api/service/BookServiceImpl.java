package com.loicmaria.api.service;

import com.loicmaria.api.DTO.BookDto;
import com.loicmaria.api.model.Book;
import com.loicmaria.api.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class BookServiceImpl extends Services<Book, BookDto, BookRepository> {



    @Override
    public Book convertDtoToEntity(BookDto bookDto){
        Book book = modelMapper.map(bookDto, Book.class);
        return book;
    }

    @Override
    public BookDto convertEntityToDto(Book book){
        BookDto bookDto = modelMapper.map(book, BookDto.class);
        return bookDto;
    }

    public Collection<BookDto> findByTitle(String title){
        Collection<Book> bookCollection = repository.findByTitle(title);
        Collection<BookDto> bookDtoCollection = convertCollectionToDto(bookCollection);
        return bookDtoCollection;
    }
}
