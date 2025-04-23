package com.hamidz.jpaCourse.repository;

import com.hamidz.jpaCourse.entity.Loan;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LoanRepository extends JpaRepository<Loan, Long> {
    List<Loan> findByStudentId(Long studentId);
    List<Loan> findByBookId(Long bookId);
}
