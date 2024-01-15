package com.example.book.dto.author.request;

import lombok.Data;
import lombok.NonNull;

@Data
public class AuthorCreateRequest {

    @NonNull
    private String name;

    @NonNull
    private String surname;
}
