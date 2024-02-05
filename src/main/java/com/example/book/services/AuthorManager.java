package com.example.book.services;

import com.example.book.dto.AllAuthorsResponse;
import com.example.book.entites.Author;
import com.example.book.mapper.ModelMapperService;
import com.example.book.repositories.AuthorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AuthorManager implements AuthorService {

    private final AuthorRepository authorRepository;

    private final ModelMapperService modelMapperService;

    @Override
    public List<AllAuthorsResponse> getAll() {
        List<Author> authors = authorRepository.findAll();
        List<AllAuthorsResponse> authorsResponse = authors.stream().map(author -> this.modelMapperService.forResponse()
                .map(author, AllAuthorsResponse.class)).collect(Collectors.toList());

        return authorsResponse;
    }

    @Override
    public void delete(int id) {
        authorRepository.deleteById(id);
    }
}
