package com.example.book.controllers;

import com.example.book.dto.AuthorDetails;
import com.example.book.dto.AuthorResponse;
import com.example.book.dto.AuthorUpdateRequest;
import com.example.book.dto.BookRequest;
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
    public List<AuthorResponse> getAllAuthors(){
        return authorService.getAll();
    }


    @GetMapping("/me")
    public AuthorDetails getAuthorDetails(){
        return authorService.getAuthorDetails();
    }


    @PostMapping("/book")
    public ResponseEntity<String> addBook(@Valid @RequestBody BookRequest bookRequest){
        try {
            authorService.addBook(bookRequest);
            return ResponseEntity.ok("book is created");
        } catch (IllegalArgumentException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping
    public ResponseEntity<String> updateAuthor(@Valid @RequestBody AuthorUpdateRequest updateRequest){
        try{
            authorService.updateAuthor(updateRequest);
            return ResponseEntity.ok("Author is updated.");
        } catch (NullPointerException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/book/{bookId}")
    public ResponseEntity<String> deleteBook(@PathVariable Long bookId){
        authorService.deleteBook(bookId);
        return ResponseEntity.ok("The book is deleted.");
    }

}
