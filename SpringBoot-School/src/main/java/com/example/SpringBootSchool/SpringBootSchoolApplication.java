package com.example.SpringBootSchool;

import com.example.SpringBootSchool.entity.Student;
import com.example.SpringBootSchool.repository.StudentRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringBootSchoolApplication {

	public static void main(String[] args) {

		ApplicationContext context = SpringApplication.run(SpringBootSchoolApplication.class, args);
		StudentRepository repo = context.getBean(StudentRepository.class);

		Student student1 = new Student(null, "Student1", "One", 17, "student1@mail.com");
		Student student2 = new Student(null, "Student2", "Two", 18, "student2@mail.com");
		Student student3 = new Student(null, "Student3", "Three", 19, "student3@mail.com");

		repo.save(student1);
		repo.save(student2);
	}

}
