package com.example.book.entites;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    String title;
    Long page;

    @ManyToOne
    @JoinColumn(name="author_id", nullable=false)
    private Author author;

    @ManyToMany(mappedBy = "favoriteBooks")
    private List<Reader> readers;
}
