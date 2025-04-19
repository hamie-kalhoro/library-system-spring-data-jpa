package com.hamidz.jpaCourse.service.impl;

import com.hamidz.jpaCourse.entity.Book;
import com.hamidz.jpaCourse.repository.BookRepository;
import com.hamidz.jpaCourse.service.BookService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;

    @Override
    public Book saveBook(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    @Override
    public Book getBookById(Long bookId) {
        return bookRepository.findById(bookId)
                .orElseThrow(() -> new RuntimeException("Book not found"));
    }

    @Override
    public Book getBookByTitle(String title) {
        return bookRepository.findByTitle(title);
    }

    @Override
    public void deleteBook(Long bookId) {
        if(!bookRepository.existsById(bookId)) {
            throw new EntityNotFoundException("Book not found with id: "+bookId);
        }
        bookRepository.deleteById(bookId);
    }
}
