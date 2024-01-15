package com.example.book.entites;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
@Table(name = "author")
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    Integer id;

    String name;
    String surname;

    @OneToMany(mappedBy = "author")
    List<Book> bookList;

}
