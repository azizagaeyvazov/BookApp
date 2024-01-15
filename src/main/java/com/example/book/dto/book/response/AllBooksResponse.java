package com.example.book.dto.book.response;

import com.example.book.dto.author.response.AllAuthorsResponse;
import lombok.Data;

@Data
public class AllBooksResponse {

    private Integer id;

    private String title;

    private Long page;

    private AllAuthorsResponse author;
}
