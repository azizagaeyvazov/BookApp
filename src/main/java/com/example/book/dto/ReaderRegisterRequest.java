package com.example.book.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ReaderRegisterRequest {

    @NotNull(message = "'name' can not be null")
    @NotBlank(message = "'name' can not be empty")
    private String name;

    @NotNull(message = "'surname' can not be null")
    @NotBlank(message = "'surname' can not be empty")
    private String surname;

    @NotNull(message = "'username' can not be null")
    @NotBlank(message = "'username' can not be empty")
    @Pattern(regexp = "^[a-zA-Z0-9]{6,12}$",
            message = "username must be of 6 to 12 length with only letter and digit")
    private String username;

    @NotNull(message = "'password' can not be null")
    @NotBlank(message = "'password' can not be empty")
    @Pattern(regexp = "^[a-zA-Z0-9]{8,12}$",
            message = "password must be with min 8,max 12 length")
    private String password;

}
