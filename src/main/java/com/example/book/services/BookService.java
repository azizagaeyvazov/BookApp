package com.example.book.services;

import com.example.book.dto.BookResponse;
import com.example.book.entites.Book;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BookService {

    List<BookResponse> getAll();

    BookResponse getBookById(Long bookId);
}
