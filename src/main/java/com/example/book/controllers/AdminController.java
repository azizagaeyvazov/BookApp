package com.example.book.controllers;

import com.example.book.services.AdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/book-app")
@RequiredArgsConstructor
public class AdminController {

    private final AdminService adminService;


    @DeleteMapping("/author/{authorId}")
    public ResponseEntity<Void> deleteAuthor(@PathVariable Long authorId) {
        adminService.deleteAuthorById(authorId);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/reader/{readerId}")
    public ResponseEntity<String> deleteReader(@PathVariable Long readerId) {
        adminService.deleteReaderById(readerId);
        return ResponseEntity.noContent().build();
    }
}
