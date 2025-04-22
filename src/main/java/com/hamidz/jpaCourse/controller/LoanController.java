package com.hamidz.jpaCourse.controller;

import com.hamidz.jpaCourse.entity.Loan;
import com.hamidz.jpaCourse.service.LoanService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

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
}
