package com.example.book.repositories;

import com.example.book.entites.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {

    @Query(value = "SELECT * FROM author order by name", nativeQuery = true)
    Optional<List<Author>> findAllOrderedByName();

    Optional<Author> findByUsername(String username);

    @Query(value = "SELECT * FROM author WHERE lower(name) LIKE lower(%:searchKey%) OR lower(surname) LIKE lower(%:searchKey%) order by name", nativeQuery = true)
    Optional<List<Author>> searchAuthorsByNameOrSurname(@Param("searchKey") String searchKey);
}
