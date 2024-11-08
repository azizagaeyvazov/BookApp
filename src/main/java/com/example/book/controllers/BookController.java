package com.example.book.controllers;

import com.example.book.dto.BookResponse;
import com.example.book.services.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/book-app/books")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:3000", methods = RequestMethod.GET)
public class BookController {

    private final BookService bookService;

    @GetMapping
    public List<BookResponse> getAllBooks() {
        return bookService.getAll();
    }

    @GetMapping("/{bookId}")
    public BookResponse getBookById(@PathVariable Long bookId) {
        return bookService.getBookById(bookId);
    }

    @GetMapping("/search")
    public List<BookResponse> searchBooks(@RequestParam String searchKey) {
        return bookService.searchBooks(searchKey);
    }
}