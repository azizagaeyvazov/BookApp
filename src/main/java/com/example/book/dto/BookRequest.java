package com.example.book.dto;

import com.example.book.entites.Author;
import lombok.Data;
import lombok.NonNull;

@Data
public class BookRequest {

    @NonNull
    String title;

    @NonNull
    Long page;

    @NonNull
    Author author;
}
