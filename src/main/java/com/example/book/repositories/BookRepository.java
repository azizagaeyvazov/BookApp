package com.example.book.repositories;

import com.example.book.entites.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer>{

    //Book findBookById(Integer id);
}
