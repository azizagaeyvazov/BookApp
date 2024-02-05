package com.example.book.repositories;

import com.example.book.entites.Reader;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ReaderRepository extends JpaRepository<Reader, Long> {
    Optional<Reader> findByUsername(String username);
}
