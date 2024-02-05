package com.example.book.authentication;

import com.example.book.exception.InvalidAuthenticationCredentials;
import com.example.book.exception.UserAlreadyExists;
import com.example.book.exception.UserNotFound;
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
            throw new UserAlreadyExists("Username already exists");
        }
        return ResponseEntity.ok(service.registerForReader(request));
    }

    @PostMapping("/authenticate/author")
    public ResponseEntity<AuthenticationResponse> authenticate(
            @RequestBody AuthorAuthenticationRequest request
    )
    {
        if (!service.validAuthorUsernameAndPassword(request.getUsername(), request.getPassword())){
            throw new InvalidAuthenticationCredentials("Username or password is incorrect");
        }
        return ResponseEntity.ok(service.authenticateAuthor(request));
    }

    @PostMapping("/authenticate/reader")
    public ResponseEntity<AuthenticationResponse> authenticate(
            @RequestBody ReaderAuthenticationRequest request
    ) {
        if (!service.validReaderUsernameAndPassword(request.getUsername(), request.getPassword())){
            throw new InvalidAuthenticationCredentials("Username or password is incorrect");
        }
        return ResponseEntity.ok(service.authenticateReader(request));
    }
}
