package com.hamidz.jpaCourse.service;

import com.hamidz.jpaCourse.entity.Book;
import org.springframework.stereotype.Service;

import java.util.List;

public interface BookService {
    Book saveBook(Book book);

    List<Book> getAllBooks();

    Book getBookById(Long bookId);

    Book getBookByTitle(String title);

    void deleteBook(Long bookId);

    void updateBook(Long bookId, String title, String isbn);
}
