package com.example.book.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BookCreateRequest {

    @NotNull(message = "Title can not be null")
    @NotBlank(message = "Title can not be empty")
    private String title;

    @NotNull(message = "Page can not be null")
    @Min(value = 1, message = "Page must be greater than or equal to 1")
    private Long page;
}
