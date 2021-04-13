package com.example.emt_lab2.config;

import com.example.emt_lab2.model.Author;
import com.example.emt_lab2.model.BookDto;
import com.example.emt_lab2.model.Category;
import com.example.emt_lab2.model.Country;
import com.example.emt_lab2.service.AuthorService;
import com.example.emt_lab2.service.BookService;
import com.example.emt_lab2.service.CountryService;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class DataInitializer {
    private final BookService bookService;
    private final AuthorService authorService;
    private final CountryService countryService;

    public DataInitializer(BookService bookService, AuthorService authorService, CountryService countryService) {
        this.bookService = bookService;
        this.authorService = authorService;
        this.countryService = countryService;
    }

    @PostConstruct
    public void init(){
        Country country = countryService.create("MKD","Europe");
        Author author = authorService.create("Aleksandra"," Zografska", country);

        BookDto bookDto = new BookDto("Book1", Category.CLASSICS.toString(),author.getId(),5);
        bookService.create(bookDto);
        bookDto = new BookDto("Book12", Category.CLASSICS.toString(),author.getId(),5);
        bookService.create(bookDto);

        bookDto = new BookDto("Book13", Category.THRILLER.toString(),author.getId(),5);
        bookService.create(bookDto);
        bookDto = new BookDto("Book14", Category.DRAMA.toString(),author.getId(),5);
        author = authorService.create("Alex"," Smith", country);
        bookService.create(bookDto);
        bookDto = new BookDto("Book15", Category.DRAMA.toString(),author.getId(),4);
        bookService.create(bookDto);
        bookDto = new BookDto("Book156", Category.DRAMA.toString(),author.getId(),4);
        bookService.create(bookDto);
        bookDto = new BookDto("Book157", Category.DRAMA.toString(),author.getId(),4);
        bookService.create(bookDto);
        bookDto = new BookDto("Book158", Category.DRAMA.toString(),author.getId(),4);
        bookService.create(bookDto);
    }
}
