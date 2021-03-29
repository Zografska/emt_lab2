package com.example.emt_lab2.service;

import com.example.emt_lab2.model.Book;
import com.example.emt_lab2.model.BookDto;

import java.util.List;
import java.util.Optional;

public interface BookService {
    List<Book> findAll();
    Optional<Book> findById(Long id);
    Optional<Book> create(BookDto bookDto);
    Optional<Book> markAsTaken(Long id);
    Optional<Book> edit(Long id, BookDto bookDto);
    void deleteById(Long id);

}
