package com.example.emt_lab2.service;

import com.example.emt_lab2.model.Author;
import com.example.emt_lab2.model.Book;
import com.example.emt_lab2.model.Category;

import java.util.List;

public interface BookService {
    List<Book> findAll();
    Book findById(Long id);
    Book create(String name, Category category, Author author, int availableCopies);
    Book markAsTaken(Long id);
    Book edit(Long id, String name, Category category, Author author, int availableCopies);

}
