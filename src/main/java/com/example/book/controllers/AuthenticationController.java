package com.example.book.controllers;

import com.example.book.dto.*;
import com.example.book.exceptions.InvalidAuthenticationCredentials;
import com.example.book.exceptions.UsernameAlreadyExists;
import com.example.book.services.AuthenticationService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/authentication")
@RequiredArgsConstructor
public class AuthenticationController {

    private final AuthenticationService service;

    @PostMapping("/register/author")
    public ResponseEntity<AuthenticationResponse> authorRegister(@Valid @RequestBody AuthorRegisterRequest request) {
        AuthenticationResponse authenticationResponse = service.registerForAuthor(request);
        return ResponseEntity.ok(authenticationResponse);
    }

    @PostMapping("/register/reader")
    public ResponseEntity<AuthenticationResponse> readerRegister(@Valid @RequestBody ReaderRegisterRequest request) {
        if (service.readerExistsByUsername(request.getUsername())) {
            throw new UsernameAlreadyExists("Username already exists");
        }
        return ResponseEntity.ok(service.registerForReader(request));
    }

    @PostMapping("/authenticate/author")
    public ResponseEntity<AuthenticationResponse> authenticate(
            @Valid @RequestBody AuthorAuthenticationRequest request
    )
    {
        if (!service.validAuthorUsernameAndPassword(request.getUsername(), request.getPassword())){
            throw new InvalidAuthenticationCredentials("Username or password is incorrect");
        }
        return ResponseEntity.ok(service.authenticateAuthor(request));
    }

    @PostMapping("/authenticate/reader")
    public ResponseEntity<AuthenticationResponse> authenticate(@RequestBody ReaderAuthenticationRequest request) {
        if (!service.validReaderUsernameAndPassword(request.getUsername(), request.getPassword())){
            throw new InvalidAuthenticationCredentials("Username or password is incorrect");
        }
        return ResponseEntity.ok(service.authenticateReader(request));
    }

    @PostMapping("/authenticate/admin")
    public ResponseEntity<AuthenticationResponse> authenticate(@RequestBody AdminAuthenticationRequest request) {
        if (!service.validAdminUsernameAndPassword(request.getUsername(), request.getPassword())){
                throw new InvalidAuthenticationCredentials("Username or password is incorrect");
            }
            return ResponseEntity.ok(service.authenticateAdmin(request));
    }
}
