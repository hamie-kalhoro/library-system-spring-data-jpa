package com.hamidz.jpaCourse.controller;

import com.hamidz.jpaCourse.entity.Student;
import com.hamidz.jpaCourse.service.StudentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/students")
public class StudentController {

    private StudentService studentService;
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping("/create-student")
    public ResponseEntity<Student> addStudent(@RequestBody Student student) {
        return ResponseEntity.ok(studentService.saveStudent(student));
    }

    @GetMapping("/get-students")
    public ResponseEntity<List<Student>> getAllStudents() {
        return ResponseEntity.ok(studentService.getAllStudents());
    }

    @GetMapping("/get-student/{studentId}")
    public ResponseEntity<Student> getStudentById(@PathVariable Long studentId) {
        return ResponseEntity.ok(studentService.getStudentById(studentId));
    }

    @GetMapping("/get-student-by-username/{username}")
    public ResponseEntity<Student> getStudentByName(@PathVariable String username) {
        return ResponseEntity.ok(studentService.getStudentByName(username));
    }

    @GetMapping("/get-student-by-email/{email}")
    public ResponseEntity<Student> getStudentByEmail(@PathVariable String email) {
        return ResponseEntity.ok(studentService.getStudentByEmail(email));
    }

    @DeleteMapping("/delete-student/{studentId}")
    public ResponseEntity<Void> deleteStudent(@PathVariable Long studentId) {
        studentService.deleteStudent(studentId);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/update-student/{username}")
    public Student updateStudent( @PathVariable String username,
                                  @RequestBody Student student ) {
        Student byName = studentService.getStudentByName(username);
        if(byName == null) {
            throw new RuntimeException("Student not found with username: " + username);
        } else {
            byName.setStudentName(byName.getStudentName() != null && !byName.getStudentName().isEmpty()
                    ? student.getStudentName()
                    : byName.getStudentName());
            byName.setEmail(byName.getEmail() != null && !byName.getEmail().isEmpty()
                    ? student.getEmail()
                    : byName.getEmail());
            byName.setEnrollmentDate(byName.getEnrollmentDate() != null && !byName.getEnrollmentDate().toString().isEmpty()
                    ? student.getEnrollmentDate()
                    : byName.getEnrollmentDate());
        }
        return studentService.saveStudent(byName);
    }
}
