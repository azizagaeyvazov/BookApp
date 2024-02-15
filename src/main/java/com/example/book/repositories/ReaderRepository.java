package com.example.book.repositories;

import com.example.book.entites.Reader;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ReaderRepository extends JpaRepository<Reader, Long> {

    @Query(value = "SELECT * FROM reader ORDER BY name", nativeQuery = true)
    Optional<List<Reader>> findAllOrderedByName();

    Optional<Reader> findByUsername(String username);

    @Query(value = "SELECT * FROM reader WHERE lower(name) LIKE lower(%:searchKey%) or" +
            " lower(surname) LIKE (%:searchKey%) order by name", nativeQuery = true)
    Optional<List<Reader>> searchReadersByNameOrSurname(@Param("searchKey") String searchKey);
}
