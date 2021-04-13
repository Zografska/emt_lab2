package com.example.emt_lab2.service;


import com.example.emt_lab2.model.Author;
import com.example.emt_lab2.model.Book;
import com.example.emt_lab2.model.Country;

import java.util.List;

public interface AuthorService {
    Author create(String name, String surname, Country country);
    Author findById(Long id);

    List<Author> findAll();
}
