package com.loicmaria.api.repository;

import com.loicmaria.api.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {
    Collection<Book> findByTitle(String title);
}
