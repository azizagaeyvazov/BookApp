package com.example.book.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ReaderUpdateRequest {

    @NotBlank(message = "name is required")
    private String name;

    @NotBlank(message = "surname is required")
    private String surname;
}
