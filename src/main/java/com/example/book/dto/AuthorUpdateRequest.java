package com.example.book.dto;

import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AuthorUpdateRequest {

    @NotNull(message = "name is required")
    private String name;

    @NotNull(message = "name is required")
    private String surname;
}
