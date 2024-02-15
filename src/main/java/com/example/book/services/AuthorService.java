package com.example.book.services;

import com.example.book.dto.*;
import com.example.book.entites.Author;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface AuthorService {

    List<AuthorResponse> getAll();

    void addBook(BookCreateRequest bookCreateRequest);

    void deleteBook(Long bookId) throws RuntimeException;

    AuthorDetails getAuthorDetails();

    void updateAuthor(AuthorUpdateRequest updateRequest);

    void updatePassword(PassUpdateRequest updateRequest);

    List<ReaderResponse> getReadersByBookId(Long bookId);

    List<AuthorResponse> searchAuthors(String searchKey);
}
