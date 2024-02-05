package com.example.book.services;

import com.example.book.dto.AllReadersResponse;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface ReaderService {

    List<AllReadersResponse> getAll();

    void addBookToFavoriteList(Integer bookId);
}
