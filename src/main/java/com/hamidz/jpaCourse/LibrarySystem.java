package com.hamidz.jpaCourse;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class LibrarySystem {

	public static void main(String[] args) {
		SpringApplication.run(LibrarySystem.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(StudentRepository studentRepository) {
		return args -> {
			Student student = new Student("Hamid","Ali","hamidali.kalhoro@gmail.com", 20);
			studentRepository.save(student);
		};
	}

}
