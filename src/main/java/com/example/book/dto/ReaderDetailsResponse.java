package com.example.book.dto;

import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ReaderDetailsResponse {

    private String name;

    private String surname;

    private String username;

    private List<BookResponse> favoriteBooks;
}
