package com.example.book.services;

import com.example.book.dto.author.request.AuthorCreateRequest;
import com.example.book.dto.author.response.AllAuthorsResponse;
import com.example.book.entites.Author;
import com.example.book.mapper.ModelMapperService;
import com.example.book.repositories.AuthorRepository;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AuthorManager implements AuthorService {

    private final AuthorRepository authorRepository;
    private final ModelMapperService modelMapperService;
    @Override
    public List<AllAuthorsResponse> getAll() {

        List<Author> authors = authorRepository.findAll();
        List<AllAuthorsResponse> authorsResponses = authors.stream().map(author -> this.modelMapperService.forResponse()
                .map(author, AllAuthorsResponse.class)).collect(Collectors.toList());

        return authorsResponses;
    }

    @Override
    public void add(AuthorCreateRequest authorRequest) {
        Author author = modelMapperService.forRequest().map(authorRequest, Author.class);
        authorRepository.save(author);
    }

    @Override
    public void delete(int id) {
        authorRepository.deleteById(id);
    }
}
