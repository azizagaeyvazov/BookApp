package com.example.book.authentication;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.NotBlank;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ReaderRegisterRequest {

    @NotBlank
    private String name;
    @NotBlank
    private String surname;
    @NotBlank
    private String username;
    @NotBlank
    private String password;


//    public boolean fieldsAreEmptyOrNull(ReaderRegisterRequest request) {
//        return request.getName() == null || request.getName().isEmpty() ||
//                request.getSurname() == null || request.getSurname().isEmpty() ||
//                request.getUsername() == null || request.getUsername().isEmpty() ||
//                request.getPassword() == null || request.getPassword().isEmpty();
//    }
}
