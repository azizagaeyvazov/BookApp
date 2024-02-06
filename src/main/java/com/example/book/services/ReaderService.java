package com.example.book.services;

import com.example.book.dto.ReaderResponse;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface ReaderService {

    List<ReaderResponse> getAll();

    void addBookToFavoriteList(Long bookId);

    void deleteBookFromFavorites(Long bookId);
}
