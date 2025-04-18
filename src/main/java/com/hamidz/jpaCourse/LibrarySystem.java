package com.hamidz.jpaCourse;

import com.hamidz.jpaCourse.entity.Student;
import com.hamidz.jpaCourse.repository.StudentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class LibrarySystem {

	public static void main(String[] args) {
		SpringApplication.run(LibrarySystem.class, args);
	}

}
