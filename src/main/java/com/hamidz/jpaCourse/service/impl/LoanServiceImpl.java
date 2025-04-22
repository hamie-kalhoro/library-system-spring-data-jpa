package com.hamidz.jpaCourse.service.impl;

import com.hamidz.jpaCourse.entity.Book;
import com.hamidz.jpaCourse.entity.Loan;
import com.hamidz.jpaCourse.entity.Student;
import com.hamidz.jpaCourse.repository.BookRepository;
import com.hamidz.jpaCourse.repository.LoanRepository;
import com.hamidz.jpaCourse.repository.StudentRepository;
import com.hamidz.jpaCourse.service.LoanService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class LoanServiceImpl implements LoanService {

    private final LoanRepository loanRepository;
    private final StudentRepository studentRepository;
    private final BookRepository bookRepository;

    @Override
    public Loan assignBookToStudent(Long bookId, Long studentId, LocalDate loanDate, LocalDate returnDate) {
        Book book = bookRepository.findById(bookId).orElseThrow(() -> new RuntimeException("Book not found with id: "+bookId));
        Student student = studentRepository.findById(studentId).orElseThrow(() -> new RuntimeException("Student not found with id: " + studentId));
        Loan loan = new Loan();
        loan.setBook(book);
        loan.setStudent(student);
        loan.setLoanDate(loanDate);
        loan.setReturnDate(returnDate);
        student.getLoans().add(loan);
        book.getLoans().add(loan);
        return loan;
    }

    @Override
    public Loan returnBook(Long loanId, LocalDate returnDate) {
        return null;
    }

    @Override
    public Loan getLoanById(Long loanId) {
        return null;
    }

    @Override
    public List<Loan> getAllLoans() {
        return null;
    }

    @Override
    public List<Loan> getLoansByStudentId(Long studentId) {
        return null;
    }

    @Override
    public List<Loan> getLoansByBookId(Long bookId) {
        return null;
    }

    @Override
    public List<Loan> getActiveLoansByStudentId(Long studentId) {
        return null;
    }

    @Override
    public boolean isBookLoaned(Long bookId) {
        return false;
    }

    @Override
    public void deleteLoan(Long loanId) {

    }

    @Override
    public boolean hasOverdueBooks(Long studentId) {
        return false;
    }

    @Override
    public List<Loan> getOverdueLoans(Long loanId) {
        return null;
    }

    @Override
    public int countLoansByStudentId(Long studentId) {
        return 0;
    }
}
