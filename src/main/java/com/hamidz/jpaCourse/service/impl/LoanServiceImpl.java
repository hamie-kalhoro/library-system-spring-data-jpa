package com.hamidz.jpaCourse.service.impl;

import com.hamidz.jpaCourse.entity.Book;
import com.hamidz.jpaCourse.entity.Loan;
import com.hamidz.jpaCourse.entity.Student;
import com.hamidz.jpaCourse.repository.BookRepository;
import com.hamidz.jpaCourse.repository.LoanRepository;
import com.hamidz.jpaCourse.repository.StudentRepository;
import com.hamidz.jpaCourse.service.LoanService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class LoanServiceImpl implements LoanService {

    private final LoanRepository loanRepository;
    private final StudentRepository studentRepository;
    private final BookRepository bookRepository;

    @Override
    public Loan assignBookToStudent( Long bookId,
                                     Long studentId,
                                     LocalDate loanDate,
                                     LocalDate returnDate) {
        Book book = bookRepository.findById(bookId)
                .orElseThrow(() -> new RuntimeException("Book not found with id: "+bookId));
        Student student = studentRepository.findById(studentId)
                .orElseThrow(() -> new RuntimeException("Student not found with id: " + studentId));
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
        Loan loan = loanRepository.findById(loanId)
                .orElseThrow(() -> new RuntimeException("Loan not found with id: " + loanId));
        loan.setReturnDate(returnDate);
        return loanRepository.save(loan);
    }

    @Override
    public Loan getLoanById(Long loanId) {
        return loanRepository.findById(loanId)
                .orElseThrow(() -> new RuntimeException("Loan not found with id: " + loanId));
    }

    @Override
    public List<Loan> getAllLoans() {
        return loanRepository.findAll();
    }

    @Override
    public List<Loan> getLoansByStudentId(Long studentId) {
        if(!studentRepository.existsById(studentId)) {
            throw new EntityNotFoundException("Student not found with id: " + studentId);
        }
        return loanRepository.findByStudentId(studentId);
    }

    @Override
    public List<Loan> getLoansByBookId(Long bookId) {
        if(!loanRepository.existsById(bookId)) {
            throw new EntityNotFoundException("Student not found with id: " + bookId);
        }
        return loanRepository.findByBookId(bookId);
    }

    @Override
    public List<Loan> getActiveLoansByStudentId(Long studentId) {
        return loanRepository.findByStudentId(studentId).stream()
                .filter(loan -> loan.getReturnDate().isAfter(LocalDate.now()))
                .collect(Collectors.toList());
    }

    @Override
    public boolean isBookLoaned(Long bookId) {
        return loanRepository.findByBookId(bookId).stream()
                .anyMatch(loan -> loan.getReturnDate().isAfter(LocalDate.now()));
    }

    @Override
    public void deleteLoan(Long loanId) {
        if(!loanRepository.existsById(loanId)) {
            throw new EntityNotFoundException("Loan not found with id: " + loanId);
        }
        loanRepository.deleteById(loanId);
    }

    @Override
    public List<Loan> hasOverdueBooks(Long studentId) {
        return loanRepository.findByStudentId(studentId).stream()
                .filter(loan -> loan.getReturnDate().isBefore(LocalDate.now()))
                .collect(Collectors.toList());
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
