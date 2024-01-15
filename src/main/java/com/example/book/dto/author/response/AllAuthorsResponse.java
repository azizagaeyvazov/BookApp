package com.example.book.dto.author.response;

import lombok.Data;

@Data
public class AllAuthorsResponse {

    private Integer id;

    private String name;

    private String surname;

    //private List<Book> books;
}
