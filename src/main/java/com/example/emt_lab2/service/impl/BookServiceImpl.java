package com.example.emt_lab2.service.impl;

import com.example.emt_lab2.model.Author;
import com.example.emt_lab2.model.Book;
import com.example.emt_lab2.model.BookDto;
import com.example.emt_lab2.model.Category;
import com.example.emt_lab2.repository.BookRepository;
import com.example.emt_lab2.service.AuthorService;
import com.example.emt_lab2.service.BookService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;
    private final AuthorService authorRepository;

    public BookServiceImpl(BookRepository bookRepository, AuthorService authorRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
    }

    @Override
    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    @Override
    public Optional<Book> findById(Long id) {
        return bookRepository.findById(id);
    }

    @Override
    public Optional<Book> create(BookDto bookDto) {
        String name = bookDto.getName();
        Author author = authorRepository.findById(bookDto.getAuthorId());
        int copies =  bookDto.getAvailableCopies();
        Category category = Category.valueOf(bookDto.getCategory());
        return Optional.of(bookRepository.save(new Book(name, category,author,copies)));
    }


    @Override
    public Optional<Book> markAsTaken(Long id) {
        Book taken = findById(id).orElseThrow(RuntimeException::new);
        int copies = taken.getAvailableCopies();
        if (copies>0)
            copies = copies - 1;
        taken.setAvailableCopies(copies);

        bookRepository.save(taken);
        return Optional.of(taken);
    }

    @Override
    public Optional<Book> edit(Long id, BookDto bookDto) {
        Book editBook = findById(id).orElseThrow(RuntimeException::new);
        editBook.setAuthor(authorRepository.findById(bookDto.getAuthorId()));
        editBook.setName(bookDto.getName());
        editBook.setAvailableCopies(bookDto.getAvailableCopies());
        editBook.setCategory(Category.valueOf(bookDto.getCategory()));

        bookRepository.save(editBook);
        return Optional.of(editBook);
    }

    @Override
    public void deleteById(Long id) {
        bookRepository.deleteById(id);
    }
}
