package com.hamidz.jpaCourse.service;

import com.hamidz.jpaCourse.entity.Student;

import java.util.List;

public interface StudentService {
    Student saveStudent(Student student);

    List<Student> getAllStudents();

    Student getStudentById(Long studentId);

    Student getStudentByName(String username);

    Student getStudentByEmail(String email);

    void deleteStudent(Long studentId);
}
