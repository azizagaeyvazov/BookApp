package com.example.book.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AdminAuthenticationRequest {

    @NotNull(message = "username can not be null")
    @NotBlank(message = "username can not be empty")
    private String username;

    @NotNull(message = "username can not be null")
    @NotBlank(message = "username can not be empty")
    private String password;
}
