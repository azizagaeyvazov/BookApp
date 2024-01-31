package com.example.book.authentication;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AuthorRegisterRequest {

    @NotNull(message = "Fields can not be empty")
    @NotBlank
    private String name;
    @NotNull(message = "Fields can not be empty")
    @NotBlank
    private String surname;
    @NotNull(message = "Fields can not be empty")
    @NotBlank
    private String username;
    @NotNull(message = "Fields can not be empty")
    @NotBlank
    private String password;
}
