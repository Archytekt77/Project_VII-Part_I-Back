package com.loicmaria.api.service;

import com.loicmaria.api.DTO.AuthorDto;
import com.loicmaria.api.model.Author;
import com.loicmaria.api.repository.AuthorRepository;
import org.springframework.stereotype.Service;


@Service
public class AuthorServiceImpl extends Services<Author, AuthorDto, AuthorRepository>{

    @Override
    public Author convertDtoToEntity(AuthorDto authorDto){
        Author author = modelMapper.map(authorDto, Author.class);
        return author;
    }

    @Override
    public AuthorDto convertEntityToDto(Author author){
        AuthorDto authorDto = modelMapper.map(author, AuthorDto.class);
        return authorDto;
    }
}
