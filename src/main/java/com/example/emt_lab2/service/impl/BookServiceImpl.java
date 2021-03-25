package com.example.emt_lab2.service.impl;

import com.example.emt_lab2.model.Author;
import com.example.emt_lab2.model.Book;
import com.example.emt_lab2.model.Category;
import com.example.emt_lab2.repository.BookRepository;
import com.example.emt_lab2.service.BookService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;

    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    @Override
    public Book findById(Long id) {
        return bookRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    @Override
    public Book create(String name, Category category, Author author, int availableCopies) {
        return bookRepository.save(new Book(name, category,author,availableCopies));
    }

    @Override
    public Book markAsTaken(Long id) {
        Book taken = findById(id);
        int copies = taken.getAvailableCopies();
        if (copies>0)
            copies = copies - 1;
        taken.setAvailableCopies(copies);

        bookRepository.save(taken);
        return taken;
    }

    @Override
    public Book edit(Long id, String name, Category category, Author author, int availableCopies) {
        Book editBook = findById(id);
        editBook.setAuthor(author);
        editBook.setName(name);
        editBook.setAvailableCopies(availableCopies);
        editBook.setCategory(category);

        bookRepository.save(editBook);
        return editBook;
    }
}
