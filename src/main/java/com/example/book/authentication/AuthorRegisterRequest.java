package com.example.book.authentication;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AuthorRegisterRequest {

    @NotNull(message = "'name' can not be null")
    @NotBlank(message = "'name' can not be empty")
    private String name;
    @NotNull(message = "'surname' can not be null")
    @NotBlank(message = "'surname' can not be empty")
    private String surname;
    @NotNull(message = "'username' can not be null")
    @NotBlank(message = "'username' can not be empty")
    private String username;
    @NotNull(message = "'password' can not be null")
    @NotBlank(message = "'password' can not be empty")
    private String password;
}
