package com.example.book.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AuthorDetailsResponse {

    private String name;

    private String surname;

    private String username;
}
