package com.example.book.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BookResponse {

    private String title;

    private Long page;

    private AuthorResponse author;
}
