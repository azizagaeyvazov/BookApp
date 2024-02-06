package com.example.book.dto;

import lombok.Data;

import java.util.List;

@Data
public class ReaderResponse {

    private String name;

    private String surname;

    private List<BookResponse> favoriteBooks;
}
