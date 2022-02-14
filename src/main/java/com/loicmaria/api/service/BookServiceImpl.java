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

    /**
     * <b>Retourne une liste de livres pour le système de recherche.</b>
     * Permet de trouver les livres en prenant le titre + la langue.
     * @param title Le titre du livre qui doit être trouvé.
     * @param language La langue du livre qui doit être trouvé.
     * @return Une liste de livres.
     */
    public Collection<BookDto> findByTitleAndLanguage(String title, String language){
        Collection<Book> bookCollection = repository.findByTitleAndLanguage(title, language);
        Collection<BookDto> bookDtoCollection = convertCollectionToDto(bookCollection);
        return bookDtoCollection;
    }

}
