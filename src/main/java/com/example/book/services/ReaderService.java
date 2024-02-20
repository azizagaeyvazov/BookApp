package com.example.book.services;

import com.example.book.dto.PassUpdateRequest;
import com.example.book.dto.ReaderDetailsResponse;
import com.example.book.dto.ReaderResponse;
import com.example.book.dto.ReaderUpdateRequest;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface ReaderService {

    List<ReaderResponse> getAll();

    void addBookToFavoriteList(Long bookId);

    void deleteBookFromFavorites(Long bookId);

    ReaderDetailsResponse getReaderDetails();

    void updateReader(ReaderUpdateRequest updateRequest);

    void updatePassword(PassUpdateRequest updateRequest);

    List<ReaderResponse> searchReaders(String searchKey);
}
