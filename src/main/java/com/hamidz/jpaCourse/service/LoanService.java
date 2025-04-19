package com.hamidz.jpaCourse.service;

import com.hamidz.jpaCourse.entity.Loan;

import java.time.LocalDate;
import java.util.List;

public interface LoanService {
    Loan assignBookToStudent(Long bookId, Long studentId, LocalDate loanDate, LocalDate returnDate);

    Loan returnBook(Long loanId, LocalDate returnDate);

    Loan getLoanById(Long loanId);

    List<Loan> getAllLoans();

    List<Loan> getLoansByStudentId(Long studentId);

    List<Loan> getLoansByBookId(Long bookId);

    List<Loan> getActiveLoansByStudentId(Long studentId);

    boolean isBookLoaned(Long bookId);

    void deleteLoan(Long loanId);

    boolean hasOverdueBooks(Long studentId);

    List<Loan> getOverdueLoans(Long loanId);

    int countLoansByStudentId(Long studentId);
}
