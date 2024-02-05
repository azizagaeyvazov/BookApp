package com.example.book.dto;

import com.example.book.entites.Book;
import lombok.Data;

import java.util.List;

@Data
public class AllReadersResponse {

    private String name;

    private String surname;

    private List<AllBooksResponse> favoriteBooks;
}
