package com.example.book.authentication;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;


@RestController
@RequestMapping("/api/authentication")
@RequiredArgsConstructor
public class AuthenticationController {

    private final AuthenticationService service;

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationExceptions(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return errors;
    }

    @PostMapping("/register/author")
    public ResponseEntity<AuthenticationResponse> authorRegister(@Valid @RequestBody AuthorRegisterRequest request) {
        if (service.authorExistsByUsername(request.getUsername())) {
            return ResponseEntity.status(HttpStatus.CONFLICT)
                    .body(new AuthenticationResponse("Username already exists"));
        }
        return ResponseEntity.ok(service.registerForAuthor(request));
    }

    @PostMapping("/register/reader")
    public ResponseEntity<AuthenticationResponse> readerRegister(@Valid @RequestBody ReaderRegisterRequest request) {
        if (service.readerExistsByUsername(request.getUsername())) {
            return ResponseEntity.status(HttpStatus.CONFLICT)
                    .body(new AuthenticationResponse("Username already exists"));
        }
        return ResponseEntity.ok(service.registerForReader(request));
    }

    @PostMapping("/authenticate/author")
    public ResponseEntity<AuthenticationResponse> authenticate(
            @RequestBody AuthorAuthenticationRequest request
    ) {
        return ResponseEntity.ok(service.authenticateAuthor(request));
    }

    @PostMapping("/authenticate/reader")
    public ResponseEntity<AuthenticationResponse> authenticate(
            @RequestBody ReaderAuthenticationRequest request
    ) {
        return ResponseEntity.ok(service.authenticateReader(request));
    }

}
