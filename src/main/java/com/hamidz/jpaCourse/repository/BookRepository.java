package com.hamidz.jpaCourse.repository;

import com.hamidz.jpaCourse.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
    Book findByTitle(String title);
}
