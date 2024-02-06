package com.example.book.dto;

import lombok.Data;

@Data
public class BookResponse {

    private Long id;

    private String title;

    private Long page;

    private AuthorResponse author;
}
