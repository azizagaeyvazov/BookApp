package com.example.book.controllers;

import com.example.book.dto.PassUpdateRequest;
import com.example.book.dto.ReaderDetailsResponse;
import com.example.book.dto.ReaderResponse;
import com.example.book.dto.ReaderUpdateRequest;
import com.example.book.services.ReaderService;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/book-app/readers")
@RequiredArgsConstructor
public class ReaderController {

    private final ReaderService readerService;

    @GetMapping
    public List<ReaderResponse> getAllReaders() {
        return readerService.getAll();
    }

    @GetMapping("/me")
    public ReaderDetailsResponse getReaderDetails() {
        return readerService.getReaderDetails();
    }

    @PostMapping("/favorite")
    public ResponseEntity<String> addFavoriteBook(@RequestParam Long bookId) {
        try {
            readerService.addBookToFavoriteList(bookId);
            return ResponseEntity.ok("The book is added to favorite list.");
        } catch (EntityNotFoundException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping
    public ResponseEntity<String> updateReader(@Valid @RequestBody ReaderUpdateRequest updateRequest) {
        try {
            readerService.updateReader(updateRequest);
            return ResponseEntity.ok("Reader is updated.");
        } catch (NullPointerException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("/pass")
    public ResponseEntity<String> updatePassword(@Valid @RequestBody PassUpdateRequest passUpdateRequest) {
        try {
            readerService.updatePassword(passUpdateRequest);
            return ResponseEntity.ok("password updated");
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/favorite/{bookId}")
    public ResponseEntity<String> deleteBookFromFavorites(@PathVariable Long bookId) {
        readerService.deleteBookFromFavorites(bookId);
        return ResponseEntity.ok("The book is deleted from you favorite list.");
    }

    @GetMapping("/search")
    public List<ReaderResponse> searchReaders(@RequestParam String searchKey) {
        return readerService.searchReaders(searchKey);
    }
}
