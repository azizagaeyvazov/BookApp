package com.example.book.services;

import com.example.book.dto.AuthorResponse;
import com.example.book.dto.BookRequest;
import com.example.book.entites.Author;
import com.example.book.entites.Book;
import com.example.book.mapper.ModelMapperService;
import com.example.book.repositories.AuthorRepository;
import com.example.book.repositories.BookRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class AuthorManager implements AuthorService {

    private final AuthorRepository authorRepository;

    private final BookRepository bookRepository;

    private final ModelMapperService modelMapperService;

    @Override
    public List<AuthorResponse> getAll() {
        List<Author> authors = authorRepository.findAll();

        return authors.stream().map(author -> this.modelMapperService.forResponse()
                .map(author, AuthorResponse.class)).collect(Collectors.toList());
    }

    @Override
    public void addBook(BookRequest bookRequest) {
        Author loggedInAuthor = getLoggedInAuthor();
        List<Book> bookList = loggedInAuthor.getBookList();

        Book book = modelMapperService.forRequest().map(bookRequest, Book.class);
        book.setAuthor(loggedInAuthor);
        if (bookAlreadyExistsInList(bookList, book)){
            log.info("You have already added this book.");
            return;
        }
        bookList.add(book);
        bookRepository.save(book);
        authorRepository.save(loggedInAuthor);
    }

    private boolean bookAlreadyExistsInList(List<Book> bookList, Book book) {
        for (Book existingBook : bookList) {
            if ((Objects.equals(existingBook.getPage(),book.getPage())) &&
                    (Objects.equals(existingBook.getTitle(), book.getTitle())) &&
                    (Objects.equals(existingBook.getAuthor(), book.getAuthor()))){
                return true;
            }
        }
        return false;
    }

    @Override
    public void deleteBook(Long bookId){
        Author loggedInAuthor = getLoggedInAuthor();
        Book book = bookRepository.findById(bookId).orElseThrow(()-> new RuntimeException("There is no a book with this id."));
        List<Book> bookList = loggedInAuthor.getBookList();
        if (bookList.contains(book)){
            bookRepository.deleteById(bookId);
        } else {
            throw new NoSuchElementException("You don't have a book with this id.");
        }
    }

    private Author getLoggedInAuthor() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (authentication == null || !authentication.isAuthenticated() || !(authentication.getPrincipal() instanceof Author)) {
            throw new IllegalStateException("User not authenticated or not of Author type");
        }
        return (Author) authentication.getPrincipal();
    }
}
