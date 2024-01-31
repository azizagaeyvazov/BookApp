package com.example.book.services;

import com.example.book.dto.AllAuthorsResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AuthorService {

    List<AllAuthorsResponse> getAll();

    void delete(int id);
}
