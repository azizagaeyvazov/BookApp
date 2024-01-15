package com.example.book.controllers;

import com.example.book.dto.author.request.AuthorCreateRequest;
import com.example.book.dto.author.response.AllAuthorsResponse;
import com.example.book.services.AuthorService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/authors")
@RequiredArgsConstructor
public class AuthorController {

    private final AuthorService authorService;

    @GetMapping
    public List<AllAuthorsResponse> getAll(){
        return authorService.getAll();
    }

    @PostMapping
    public void add(@RequestBody AuthorCreateRequest authorRequest){
        authorService.add(authorRequest);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id){
        authorService.delete(id);
    }
}
