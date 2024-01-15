package com.example.book.dto.book.request;

import com.example.book.dto.author.request.AuthorCreateRequest;
import com.example.book.entites.Author;
import lombok.Data;
import lombok.NonNull;

@Data
public class BookCreateRequest {

    @NonNull
    String title;

    @NonNull
    Long page;

    @NonNull
    Author author;
}
