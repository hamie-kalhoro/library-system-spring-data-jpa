package com.hamidz.jpaCourse.service.impl;

import com.hamidz.jpaCourse.entity.Book;
import com.hamidz.jpaCourse.entity.Student;
import com.hamidz.jpaCourse.repository.BookRepository;
import com.hamidz.jpaCourse.service.BookService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {

    @Override
    public Book saveBook(Book book) {
        return null;
    }

    @Override
    public List<Book> getAllBooks() {
        return null;
    }

    @Override
    public Book getBookById(Long bookId) {
        return null;
    }

    @Override
    public Book getBookByTitle(String title) {
        return null;
    }

    @Override
    public void deleteBook(Long bookId) {

    }

    @Override
    public void updateBook(Long bookId, String title, String isbn) {

    }
}
