package com.example.book.services;

import com.example.book.dto.*;
import com.example.book.entites.Author;
import com.example.book.entites.Book;
import com.example.book.mapper.ModelMapperService;
import com.example.book.repositories.AuthorRepository;
import com.example.book.repositories.BookRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.handler.annotation.support.MethodArgumentNotValidException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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
        if (bookExistsInList(bookList, book)) {
            throw new IllegalArgumentException("Book already exists");
        }
        bookList.add(book);
        bookRepository.save(book);
        authorRepository.save(loggedInAuthor);
    }

    @Override
    public void deleteBook(Long bookId) {
        Author loggedInAuthor = getLoggedInAuthor();
        Book book = bookRepository.findById(bookId).orElseThrow(() -> new RuntimeException("There is no a book with this id."));
        List<Book> bookList = loggedInAuthor.getBookList();
        if (bookExistsInList(bookList, book)) {
            bookRepository.deleteById(bookId);
        } else {
            throw new NoSuchElementException("You don't have a book with this id.");
        }
    }

    @Override
    public AuthorDetails getAuthorDetails() {
        return modelMapperService.forResponse().map(getLoggedInAuthor(), AuthorDetails.class);
    }

    @Override
    public void updateAuthor(AuthorUpdateRequest updateRequest) {
        if (updateRequest == null) {
            throw new NullPointerException("Update failed");
        }
        if (updateRequest.getName() != null) {
            if (updateRequest.getName().isBlank()) {
                throw new NullPointerException("name can not be blank");
            }
            getLoggedInAuthor().setName(updateRequest.getName());
        }
        if (updateRequest.getSurname() != null) {
            if (updateRequest.getSurname().isBlank()) {
                throw new NullPointerException("surname can not be blank");
            }
            getLoggedInAuthor().setSurname(updateRequest.getSurname());
        }
        authorRepository.save(getLoggedInAuthor());
    }

    @Override
    public void updatePassword(PassUpdateRequest updateRequest) {
        if (BCrypt.checkpw(updateRequest.getPassword(), getLoggedInAuthor().getPassword())) {
            String hashedNewPass = BCrypt.hashpw(updateRequest.getNewPassword(), BCrypt.gensalt());
            getLoggedInAuthor().setPassword(hashedNewPass);
            authorRepository.save(getLoggedInAuthor());
        } else throw new RuntimeException("password is wrong");
    }

    private boolean bookExistsInList(List<Book> bookList, Book book) {
        for (Book existingBook : bookList) {
            if ((Objects.equals(existingBook.getPage(), book.getPage())) &&
                    (Objects.equals(existingBook.getTitle(), book.getTitle()))) {
                return true;
            }
        }
        return false;
    }

    private Author getLoggedInAuthor() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (authentication == null || !authentication.isAuthenticated() || !(authentication.getPrincipal() instanceof Author)) {
            throw new IllegalStateException("Author not authenticated or not of Author type");
        }
        return (Author) authentication.getPrincipal();
    }
}
