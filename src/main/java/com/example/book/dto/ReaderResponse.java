package com.example.book.dto;

import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ReaderResponse {

    private String name;

    private String surname;

    private List<BookResponse> favoriteBooks;
}
