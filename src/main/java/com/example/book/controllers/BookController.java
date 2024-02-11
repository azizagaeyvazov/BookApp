package com.example.book.controllers;

import com.example.book.dto.BookResponse;
import com.example.book.services.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/book-app/books")
@RequiredArgsConstructor
public class BookController {

    private final BookService bookService;

    @GetMapping
    public List<BookResponse> getAllBooks(){
        return bookService.getAll();
    }

    @GetMapping("/{bookId}")
    public BookResponse getBookById(@PathVariable Long bookId){
        return bookService.getBookById(bookId);
    }
}
