package com.example.book.services;

import com.example.book.dto.BookResponse;
import com.example.book.entites.Book;
import com.example.book.mapper.ModelMapperService;
import com.example.book.repositories.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BookManager implements BookService {

    private final BookRepository bookRepository;

    private final ModelMapperService modelMapperService;

    @Override
    public List<BookResponse> getAll() {

        List<Book> books = bookRepository.findAllOrderedByTitle().orElseThrow();
        books.sort(Comparator.comparing(Book::getTitle));

        return books.stream().map(book -> this.modelMapperService.forResponse()
                .map(book, BookResponse.class)).collect(Collectors.toList());
    }

    @Override
    public BookResponse getBookById(Long bookId) {
        Book book = bookRepository.findById(bookId).orElseThrow();
        return modelMapperService.forResponse().map(book, BookResponse.class);
    }

    @Override
    public List<BookResponse> searchBooks(String searchKey) {
        List<Book> books = bookRepository.searchBooksByNameOrSurname(searchKey.trim()).orElseThrow();
        return books.stream().map(book -> this.modelMapperService.forResponse().map(
                book, BookResponse.class)).collect(Collectors.toList());
    }
}
