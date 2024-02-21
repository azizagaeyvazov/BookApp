package com.example.book.controllers;

import com.example.book.services.AdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/book-app/admin")
@RequiredArgsConstructor
public class AdminController {

    private final AdminService adminService;


    @DeleteMapping("/author/{authorId}")
    public void deleteAuthor(@PathVariable Long authorId) {
        adminService.deleteAuthorById(authorId);
    }

    @DeleteMapping("/reader/{readerId}")
    public void deleteReader(@PathVariable Long readerId) {
        adminService.deleteReaderById(readerId);
    }
}
