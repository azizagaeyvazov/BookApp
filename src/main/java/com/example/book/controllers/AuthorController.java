package com.example.book.controllers;

import com.example.book.dto.AllAuthorsResponse;
import com.example.book.dto.CreateBookRequest;
import com.example.book.services.AuthorService;
import com.example.book.services.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/bookapp/authors")
@RequiredArgsConstructor
public class AuthorController {

    private final AuthorService authorService;

    private final BookService bookService;

    @GetMapping
    public List<AllAuthorsResponse> getAll(){
        return authorService.getAll();
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id){
        authorService.delete(id);
    }

//    @PostMapping
//    public void addBook(@RequestBody CreateBookRequest createBookRequest){
//
//    }
}
