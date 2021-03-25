package com.example.emt_lab2.service.impl;

import com.example.emt_lab2.model.Author;
import com.example.emt_lab2.model.Country;
import com.example.emt_lab2.repository.AuthorRepository;
import com.example.emt_lab2.service.AuthorService;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository authorRepository;

    public AuthorServiceImpl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    public Author create(String name,String surname, Country country) {
        return authorRepository.save(new Author(name,surname,country));
    }

    @Override
    public Author findById(Long id) {
        return authorRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }
}
