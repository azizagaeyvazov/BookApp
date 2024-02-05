package com.example.book.services;

import com.example.book.dto.AllReadersResponse;
import com.example.book.entites.Book;
import com.example.book.entites.Reader;
import com.example.book.mapper.ModelMapperService;
import com.example.book.repositories.BookRepository;
import com.example.book.repositories.ReaderRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class ReaderManager implements ReaderService {

    private final ModelMapperService modelMapperService;

    private final ReaderRepository readerRepository;

    private final BookRepository bookRepository;

    @Override
    public List<AllReadersResponse> getAll() {
        List<Reader> readers = readerRepository.findAll();
        return readers.stream().map(reader -> this.modelMapperService.forResponse()
                .map(reader, AllReadersResponse.class)).collect(Collectors.toList());
    }
    @Override
    public void addBookToFavoriteList(Integer bookId) {
        Reader loggedInReader = getLoggedInReader();

        Book book = bookRepository.findById(bookId).orElseThrow(() -> new EntityNotFoundException("Book not found"));

        loggedInReader.getFavoriteBooks().add(book);
        readerRepository.save(loggedInReader);
    }

    private Reader getLoggedInReader() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (authentication == null || !authentication.isAuthenticated() || !(authentication.getPrincipal() instanceof Reader)) {
            throw new IllegalStateException("User not authenticated or not of Reader type");
        }
        return (Reader) authentication.getPrincipal();
    }

}
