package com.example.book.repositories;

import com.example.book.entites.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Integer> {

    Optional<Author> findFirstBy();

    Optional<Author> findByUsername(String username);
}
