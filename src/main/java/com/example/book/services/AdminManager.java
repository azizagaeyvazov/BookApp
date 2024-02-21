package com.example.book.services;

import com.example.book.repositories.AuthorRepository;
import com.example.book.repositories.ReaderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AdminManager implements AdminService {

    private final AuthorRepository authorRepository;

    private final ReaderRepository readerRepository;


    @Override
    public void deleteAuthorById(Long authorId) {
        authorRepository.findById(authorId).orElseThrow();
        authorRepository.deleteById(authorId);
    }

    @Override
    public void deleteReaderById(Long readerId) {
        readerRepository.findById(readerId).orElseThrow();
        readerRepository.deleteById(readerId);
    }
}
