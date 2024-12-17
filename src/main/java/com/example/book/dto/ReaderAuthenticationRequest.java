package com.example.book.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ReaderAuthenticationRequest {

    @NotBlank(message = "username can not be empty")
    private String username;

    @NotBlank(message = "password can not be empty")
    private String password;
}
