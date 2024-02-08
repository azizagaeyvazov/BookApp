package com.example.book.services;

import com.example.book.dto.PassUpdateRequest;
import com.example.book.dto.ReaderDetails;
import com.example.book.dto.ReaderResponse;
import com.example.book.dto.ReaderUpdateRequest;
import com.example.book.entites.Book;
import com.example.book.entites.Reader;
import com.example.book.mapper.ModelMapperService;
import com.example.book.repositories.BookRepository;
import com.example.book.repositories.ReaderRepository;
import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class ReaderManager implements ReaderService {

    private final ModelMapperService modelMapperService;

    private final ReaderRepository readerRepository;

    private final BookRepository bookRepository;

    @Override
    public List<ReaderResponse> getAll() {
        List<Reader> readers = readerRepository.findAll();
        return readers.stream().map(reader -> this.modelMapperService.forResponse()
                .map(reader, ReaderResponse.class)).collect(Collectors.toList());
    }

    @Override
    public void addBookToFavoriteList(Long bookId) {
        Reader loggedInReader = getLoggedInReader();

        Book book = bookRepository.findById(bookId).orElseThrow(() -> new EntityNotFoundException("Book not found"));
        List<Book> favoriteList = loggedInReader.getFavoriteBooks();
        if (bookExistsInList(favoriteList, book)) {
            throw new EntityExistsException("The book is already exists in your favorite list");
        }
        loggedInReader.getFavoriteBooks().add(book);
        readerRepository.save(loggedInReader);
    }

    @Override
    public void deleteBookFromFavorites(Long bookId) {
        Reader loggedInReader = getLoggedInReader();

        Book book = bookRepository.findById(bookId).orElseThrow(() -> new EntityNotFoundException("Book not found"));
        List<Book> favoriteList = loggedInReader.getFavoriteBooks();
        if (favoriteList.removeIf(b -> b.getId().equals(book.getId()))) {
            loggedInReader.setFavoriteBooks(favoriteList);
            readerRepository.save(loggedInReader);
        } else throw new RuntimeException("You don't have this book in your favorite list.");
    }

    @Override
    public ReaderDetails getReaderDetails() {
        return modelMapperService.forResponse().map(getLoggedInReader(), ReaderDetails.class);
    }

    @Override
    public void updateReader(ReaderUpdateRequest updateRequest) {
        if (updateRequest == null){
            throw new NullPointerException("Update failed");
        }
        if (updateRequest.getName() != null){
            if (updateRequest.getName().isBlank()){
                throw new NullPointerException("name can not be blank");
            }
            getLoggedInReader().setName(updateRequest.getName());
        }
        if (updateRequest.getSurname() != null){
            if (updateRequest.getSurname().isBlank()){
                throw new NullPointerException("surname can not be blank");
            }
            getLoggedInReader().setSurname(updateRequest.getSurname());
        }
        readerRepository.save(getLoggedInReader());
    }

    @Override
    public void updatePassword(PassUpdateRequest updateRequest) {
        if (BCrypt.checkpw(updateRequest.getPassword(), getLoggedInReader().getPassword())) {
            String hashedNewPass = BCrypt.hashpw(updateRequest.getNewPassword(), BCrypt.gensalt());
            getLoggedInReader().setPassword(hashedNewPass);
            readerRepository.save(getLoggedInReader());
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

    private Reader getLoggedInReader() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (authentication == null || !authentication.isAuthenticated() || !(authentication.getPrincipal() instanceof Reader)) {
            throw new IllegalStateException("User not authenticated or not of Reader type");
        }
        return (Reader) authentication.getPrincipal();
    }
}
