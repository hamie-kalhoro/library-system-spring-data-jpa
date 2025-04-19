package com.hamidz.jpaCourse.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "books")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(
            name = "book_id",
            updatable = false
    )
    private Long id;
    @Column(
            name = "book_title",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String title;
    @Column(
            name = "isbn",
            length = 13 // 13 is the standard length for ISBN-13
    )
    private String isbn;
    private LocalDate publishedDate;

}
