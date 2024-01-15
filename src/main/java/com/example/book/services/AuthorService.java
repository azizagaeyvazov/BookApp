package com.example.book.services;

import com.example.book.dto.author.request.AuthorCreateRequest;
import com.example.book.dto.author.response.AllAuthorsResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AuthorService {

    List<AllAuthorsResponse> getAll();

    void add(AuthorCreateRequest authorRequest);

    void delete(int id);
}
