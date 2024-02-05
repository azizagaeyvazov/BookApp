package com.example.book.services;

import com.example.book.dto.CreateBookRequest;
import com.example.book.dto.AllBooksResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BookService {

    List<AllBooksResponse> getAll();

    void add(CreateBookRequest bookRequest, int authorId);

    void delete(int id);
}
