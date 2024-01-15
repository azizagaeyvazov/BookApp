package com.example.book.services;

import com.example.book.dto.author.request.AuthorCreateRequest;
import com.example.book.dto.book.request.BookCreateRequest;
import com.example.book.dto.book.response.AllBooksResponse;
import com.example.book.entites.Author;
import com.example.book.entites.Book;
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
    public List<AllBooksResponse> getAll(){

        List<Book> books = bookRepository.findAll();
        List<AllBooksResponse> booksResponses = books.stream().map(book -> this.modelMapperService.forResponse()
                .map(book, AllBooksResponse.class)).collect(Collectors.toList());

        return booksResponses;
    }

    @Override
    public void add(BookCreateRequest bookRequest, int authorId) {
        Optional<Author> author = Optional.ofNullable(authorRepository.findFirstBy().orElseThrow(NullPointerException::new));
        bookRequest.setAuthor(author.get());
        Book book = modelMapperService.forRequest().map(bookRequest, Book.class);
        bookRepository.save(book);
    }
    @Override
    public void delete(int id) {
        bookRepository.deleteById(id);
    }
}
