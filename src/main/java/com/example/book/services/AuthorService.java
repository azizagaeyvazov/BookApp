package com.example.book.services;

import com.example.book.dto.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AuthorService {

    List<AuthorResponse> getAll();

    void addBook(BookRequest bookRequest);

    void deleteBook(Long bookId) throws RuntimeException;

    AuthorDetails getAuthorDetails();

    void updateAuthor(AuthorUpdateRequest updateRequest);

    void updatePassword(PassUpdateRequest updateRequest);
}
