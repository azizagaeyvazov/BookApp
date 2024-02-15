package com.example.book.repositories;

import com.example.book.entites.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BookRepository extends JpaRepository<Book, Long>{

    @Query(value = "SELECT * FROM book order by title", nativeQuery = true)
    Optional<List<Book>> findAllOrderedByTitle();

    @Query(value = "SELECT * FROM book WHERE lower(title) LIKE lower(%:searchKey%) order by title", nativeQuery = true)
    Optional<List<Book>> searchBooksByNameOrSurname(@Param("searchKey") String searchKey);
}