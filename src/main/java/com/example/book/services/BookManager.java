package com.example.book.services;

import com.example.book.dto.BookRequest;
import com.example.book.dto.BookResponse;
import com.example.book.entites.Author;
import com.example.book.entites.Book;
import com.example.book.exception.UserNotFound;
import com.example.book.mapper.ModelMapperService;
import com.example.book.repositories.AuthorRepository;
import com.example.book.repositories.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BookManager implements BookService {
    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;
    private final ModelMapperService modelMapperService;

    @Override
    public List<BookResponse> getAll(){

        List<Book> books = bookRepository.findAll();
        List<BookResponse> bookRespons = books.stream().map(book -> this.modelMapperService.forResponse()
                .map(book, BookResponse.class)).collect(Collectors.toList());

        return bookRespons;
    }

    @Override
    public void add(BookRequest bookRequest, Long authorId) {
        Optional<Author> author = authorRepository.findById(authorId);
        if (author.isPresent()){
            bookRequest.setAuthor(author.get());
            Book book = modelMapperService.forRequest().map(bookRequest, Book.class);
            bookRepository.save(book);
        } else throw new UserNotFound("Author not found with given id");
    }
    @Override
    public void delete(Long id) {
        bookRepository.deleteById(id);
    }
}
