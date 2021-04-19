package com.loicmaria.api.service;

import com.loicmaria.api.DTO.BookDto;
import com.loicmaria.api.model.Book;
import com.loicmaria.api.repository.BookRepository;
import org.springframework.stereotype.Service;

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

}
