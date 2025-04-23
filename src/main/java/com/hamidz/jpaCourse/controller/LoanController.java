package com.hamidz.jpaCourse.controller;

import com.hamidz.jpaCourse.entity.Loan;
import com.hamidz.jpaCourse.service.LoanService;
import jakarta.websocket.server.PathParam;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/loans")
@RequiredArgsConstructor
public class LoanController {

    private final LoanService loanService;

    @PostMapping("/assign")
    public ResponseEntity<Loan> assignBookToStudent( @RequestParam Long bookId,
                                     @RequestParam Long studentId,
                                     @RequestParam String loanDate,
                                     @RequestParam String returnDate ) {
        Loan loan = loanService.assignBookToStudent(bookId, studentId, LocalDate.parse(loanDate), LocalDate.parse(returnDate));
        return new ResponseEntity<>(loan, HttpStatus.CREATED);
    }

    @PutMapping("/return/{loanId}")
    public ResponseEntity<Loan> returnBook(@PathVariable Long loanId, @RequestParam LocalDate returnDate) {
        return new ResponseEntity<>(loanService.returnBook(loanId, returnDate), HttpStatus.OK);
    }

    @GetMapping("/get-loan/{loanId}")
    public ResponseEntity<Loan> getLoanById(@PathVariable Long loanId) {
        return new ResponseEntity<>(loanService.getLoanById(loanId), HttpStatus.OK);
    }

    @GetMapping()
    public ResponseEntity<List<Loan>> getAllLoans() {
        return new ResponseEntity<>(loanService.getAllLoans(), HttpStatus.OK);
    }

    @GetMapping("/student/{studentId}")
    public ResponseEntity<List<Loan>> getLoansByStudentId(@PathVariable Long studentId) {
        return new ResponseEntity<>(loanService.getLoansByStudentId(studentId), HttpStatus.OK);
    }

    @GetMapping("/book/{bookId}")
    public ResponseEntity<List<Loan>> getLoansByBookId(@PathVariable Long bookId) {
        return new ResponseEntity<>(loanService.getLoansByBookId(bookId), HttpStatus.OK);
    }

    @GetMapping("/student/{studentId}/active")
    public ResponseEntity<List<Loan>> getActiveLoansByStudentId(@PathVariable Long studentId) {
        return new ResponseEntity<>(loanService.getActiveLoansByStudentId(studentId), HttpStatus.OK);
    }

    @GetMapping("/book/{bookId}/loaned")
    public ResponseEntity<Boolean> isBookLoaned(@PathVariable Long bookId) {
        return new ResponseEntity<>(loanService.isBookLoaned(bookId), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{loanId}")
    public ResponseEntity<?> deleteLoan(@PathVariable Long loanId) {
        loanService.deleteLoan(loanId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/student/{studentId}/overdue")
    public ResponseEntity<List<Loan>> getOverdueBooks(@PathVariable Long studentId) {
        return new ResponseEntity<>(loanService.hasOverdueBooks(studentId), HttpStatus.OK);
    }
}
