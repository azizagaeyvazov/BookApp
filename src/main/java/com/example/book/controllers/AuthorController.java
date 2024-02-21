package com.example.book.controllers;

import com.example.book.dto.*;
import com.example.book.services.AuthorService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/book-app/authors")
@RequiredArgsConstructor
public class AuthorController {

    private final AuthorService authorService;

    @GetMapping
    public List<AuthorResponse> getAllAuthors() {
        return authorService.getAll();
    }


    @GetMapping("/me")
    public AuthorDetailsResponse getAuthorDetails() {
        return authorService.getAuthorDetails();
    }

    @GetMapping("/books/{bookId}/readers")
    public List<ReaderResponse> getReadersByBookId(@PathVariable Long bookId) {
        return authorService.getReadersByBookId(bookId);
    }


    @PostMapping("/book")
    public ResponseEntity<String> addBook(@Valid @RequestBody BookCreateRequest bookCreateRequest) {
        try {
            authorService.addBook(bookCreateRequest);
            return ResponseEntity.ok("book is created");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping
    public ResponseEntity<String> updateAuthor(@Valid @RequestBody AuthorUpdateRequest updateRequest) {
        try {
            authorService.updateAuthor(updateRequest);
            return ResponseEntity.ok("Author is updated.");
        } catch (NullPointerException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("/pass")
    public ResponseEntity<String> updatePassword(@Valid @RequestBody PassUpdateRequest passUpdateRequest) {
        try {
            authorService.updatePassword(passUpdateRequest);
            return ResponseEntity.ok("password updated");
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }


    @DeleteMapping("/book/{bookId}")
    public ResponseEntity<String> deleteBook(@PathVariable Long bookId) {
        authorService.deleteBook(bookId);
        return ResponseEntity.ok("The book is deleted.");
    }


    @GetMapping("/search")
    public List<AuthorResponse> getSearchedAuthors(@RequestParam String searchKey) {
        return authorService.searchAuthors(searchKey);
    }

}
