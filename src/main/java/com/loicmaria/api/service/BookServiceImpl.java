package com.loicmaria.api.service;

import com.loicmaria.api.model.Book;
import com.loicmaria.api.repository.BookRepository;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl extends Services<Book, BookRepository>{
}
