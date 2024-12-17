package com.example.book.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PassUpdateRequest {

    @NotNull(message = "the current password is required")
    private String password;

    @NotBlank(message = "'new password' can not be empty")
    @Pattern(regexp = "^[a-zA-Z0-9]{8,12}$",
            message = "password must be with min 8,max 12 length")
    private String newPassword;
}
