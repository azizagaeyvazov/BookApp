package com.example.book.services;

import com.example.book.dto.AuthorDetails;
import com.example.book.dto.AuthorResponse;
import com.example.book.dto.AuthorUpdateRequest;
import com.example.book.dto.BookRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AuthorService {

    List<AuthorResponse> getAll();

    void addBook(BookRequest bookRequest);

    void deleteBook(Long bookId) throws RuntimeException;

    AuthorDetails getAuthorDetails();

    void updateAuthor(AuthorUpdateRequest updateRequest);
}
