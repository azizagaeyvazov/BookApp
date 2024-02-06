package com.example.book.services;

import com.example.book.dto.BookResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BookService {

    List<BookResponse> getAll();
}
