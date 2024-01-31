package com.example.book.dto;

import lombok.Data;

@Data
public class AllBooksResponse {

    private Integer id;

    private String title;

    private Long page;

    private AllAuthorsResponse author;
}
