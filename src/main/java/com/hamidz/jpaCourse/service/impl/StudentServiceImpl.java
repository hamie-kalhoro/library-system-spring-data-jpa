package com.hamidz.jpaCourse.service.impl;

import com.hamidz.jpaCourse.entity.Student;
import com.hamidz.jpaCourse.repository.StudentRepository;
import com.hamidz.jpaCourse.service.StudentService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    StudentRepository studentRepository;
    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public Student getStudentById(Long studentId) {
        return studentRepository.findById(studentId)
                .orElseThrow(() -> new RuntimeException("Student not found with id: " + studentId));
    }

    @Override
    public Student getStudentByName(String username) {
        return studentRepository.findByStudentName(username);
    }

    @Override
    public void deleteStudent(Long studentId) {
        if(!studentRepository.existsById(studentId)) {
            throw new EntityNotFoundException("Student not found with id: " + studentId);
        }
        studentRepository.deleteById(studentId);
    }

    @Override
    public Student getStudentByEmail(String email) {
        Student byEmail = studentRepository.findByEmail(email);
        if (byEmail == null) {
            throw new RuntimeException("Student not found with email: " + email);
        }
        return byEmail;
    }
}
