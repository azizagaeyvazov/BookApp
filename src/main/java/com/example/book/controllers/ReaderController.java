package com.example.book.controllers;

import com.example.book.dto.ReaderResponse;
import com.example.book.services.ReaderService;
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
    public List<ReaderResponse> getAllReaders(){
        return readerService.getAll();
    }

    @PostMapping("/favorite-book")
    public ResponseEntity<String> addFavoriteBook(@RequestParam Long bookId){
        readerService.addBookToFavoriteList(bookId);
        return ResponseEntity.ok("The book is added to favorite list.");
    }

    @DeleteMapping("/favorite-book/{bookId}")
    public ResponseEntity<String> deleteBookFromFavorites(@PathVariable Long bookId){
        readerService.deleteBookFromFavorites(bookId);
        return ResponseEntity.ok("The book is deleted from you favorite list.");
    }
}
