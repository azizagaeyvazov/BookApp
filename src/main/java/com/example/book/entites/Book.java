package com.example.book.entites;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;

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
}
