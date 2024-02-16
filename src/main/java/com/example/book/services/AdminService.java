package com.example.book.services;

import org.springframework.stereotype.Service;

public interface AdminService {

    void deleteAuthorById(Long authorId);

    void deleteReaderById(Long authorId);
}
