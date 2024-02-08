package com.example.book.dto;

import lombok.Data;

import java.util.List;
@Data
public class ReaderDetails {

    private String name;

    private String surname;

    private String username;

    private List<BookResponse> favoriteBooks;
}
