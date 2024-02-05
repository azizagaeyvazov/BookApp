package com.example.book.controllers;

import com.example.book.dto.AuthorResponse;
import com.example.book.dto.BookRequest;
import com.example.book.services.AuthorService;
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

    @PostMapping("/book")
    public ResponseEntity<String> addBook(@RequestBody BookRequest bookRequest){
        authorService.addBook(bookRequest);
        return ResponseEntity.ok("The book is added.");
    }

    @DeleteMapping("/book/{bookId}")
    public ResponseEntity<String> deleteBook(@PathVariable Long bookId){
        authorService.deleteBook(bookId);
        return ResponseEntity.ok("The book is deleted.");
    }
}
