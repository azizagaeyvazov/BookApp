package com.example.book.services;

import com.example.book.dto.BookResponse;
import com.example.book.entites.Book;
import com.example.book.mapper.ModelMapperService;
import com.example.book.repositories.AuthorRepository;
import com.example.book.repositories.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BookManager implements BookService {

    private final BookRepository bookRepository;

    private final ModelMapperService modelMapperService;

    @Override
    public List<BookResponse> getAll() {

        List<Book> books = bookRepository.findAll();

        return books.stream().map(book -> this.modelMapperService.forResponse()
                .map(book, BookResponse.class)).collect(Collectors.toList());
    }

    @Override
    public BookResponse getBookById(Long bookId) {
        Book book = bookRepository.findById(bookId).orElseThrow();
        return modelMapperService.forResponse().map(book, BookResponse.class);
    }
}
