package com.example.book.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class PassUpdateRequest {

    private String password;

    @NotNull(message = "'password' can not be null")
    @NotBlank(message = "'password' can not be empty")
    @Pattern(regexp = "^[a-zA-Z0-9]{8,12}$",
            message = "password must be with min 8,max 12 length")
    private String newPassword;
}
