package com.hamidz.jpaCourse.repository;

import com.hamidz.jpaCourse.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Long> {

    Student findByStudentName(String studentName);
    Student findByEmail(String email);
    List<Student> findStudentsByEmail(String email);

}
