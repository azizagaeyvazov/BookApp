package com.example.book.services;

import com.example.book.dto.ReaderDetails;
import com.example.book.dto.ReaderResponse;
import com.example.book.dto.ReaderUpdateRequest;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface ReaderService {

    List<ReaderResponse> getAll();

    void addBookToFavoriteList(Long bookId);

    void deleteBookFromFavorites(Long bookId);

    ReaderDetails getReaderDetails();

    void updateReader(ReaderUpdateRequest updateRequest);
}
