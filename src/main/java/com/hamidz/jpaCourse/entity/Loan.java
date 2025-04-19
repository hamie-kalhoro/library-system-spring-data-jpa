package com.hamidz.jpaCourse.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;

@Data @NoArgsConstructor @AllArgsConstructor
@Entity @Table(name = "loans")
public class Loan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "loan_date") @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate loanDate;
    @Column(name = "return_date") @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate returnDate;

    @ManyToOne()
    @JoinColumn(name = "book_id")
    private Book book;

    @ManyToOne()
    @JoinColumn(name = "student_id")
    private Book student;
}
