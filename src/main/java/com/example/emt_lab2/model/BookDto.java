package com.example.emt_lab2.model;

import lombok.Data;


@Data
public class BookDto {
    String name;
    String category;
    Long authorId;
    int availableCopies;

    public BookDto() {
    }

    public BookDto(String name, String category, Long authorId, int availableCopies) {
        this.name = name;
        this.category = category;
        this.authorId = authorId;
        this.availableCopies = availableCopies;
    }
}
