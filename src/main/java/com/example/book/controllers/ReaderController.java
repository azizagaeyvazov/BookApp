package com.example.book.controllers;

import com.example.book.dto.AllReadersResponse;
import com.example.book.services.ReaderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/bookapp/readers")
@RequiredArgsConstructor
public class ReaderController {

    private final ReaderService readerService;

    @GetMapping
    public List<AllReadersResponse> getAllReader(){
        return readerService.getAll();
    }

    @PostMapping("/addFavoriteBook")
    public void addFavoriteBook(@RequestParam Integer bookId){
        readerService.addBookToFavoriteList(bookId);
    }
}
