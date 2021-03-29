package com.example.emt_lab2.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Book {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    Long id;
    String name;
    @Enumerated(EnumType.STRING)
    Category category;
    @ManyToOne
    Author author;
    int availableCopies;

    public Book(String name, Category category, Author author, int availableCopies) {
        this.name = name;
        this.category = category;
        this.author = author;
        this.availableCopies = availableCopies;
    }

    public Book() {
    }
}
