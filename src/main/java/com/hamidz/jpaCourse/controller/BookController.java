package com.hamidz.jpaCourse.controller;

import com.hamidz.jpaCourse.entity.Book;
import com.hamidz.jpaCourse.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController @RequestMapping(path = "/books")
@RequiredArgsConstructor
public class BookController {

    private final BookService bookService;

    @PostMapping("/add-book")
    public ResponseEntity<?> addBook(@RequestBody Book book) {
        return new ResponseEntity<>(bookService.saveBook(book), HttpStatus.CREATED);
    }

    @GetMapping("/book-id/{bookId}")
    public ResponseEntity<Book> getBookById(@PathVariable Long bookId) {
        try {
            return new ResponseEntity<>(bookService.getBookById(bookId), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/get-all-books")
    public ResponseEntity<List<Book>> getAllBooks() {
        try {
            return new ResponseEntity<>(bookService.getAllBooks(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/book-title/{bookTitle}")
    public ResponseEntity<Book> getBookByTitle(@PathVariable String bookTitle) {
        try {
            return new ResponseEntity<>(bookService.getBookByTitle(bookTitle), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/delete-book/{bookId}")
    public ResponseEntity<?> deleteBook(@PathVariable Long bookId) {
        try {
            bookService.deleteBook(bookId);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/update-book/id/{bookId}")
    public ResponseEntity<Book> updateBook(@PathVariable Long bookId, @RequestBody Book book) {
        try {
            Book existingBook = bookService.getBookById(bookId);

            if (existingBook == null) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }

            if (book.getTitle() != null && !book.getTitle().isEmpty()) {
                existingBook.setTitle(book.getTitle());
            }

            if (book.getIsbn() != null && !book.getIsbn().isEmpty()) {
                existingBook.setIsbn(book.getIsbn());
            }

            if (book.getPublishedDate() != null) {
                existingBook.setPublishedDate(book.getPublishedDate());
            }

            Book updatedBook = bookService.saveBook(existingBook);
            return new ResponseEntity<>(updatedBook, HttpStatus.OK);

        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

}
