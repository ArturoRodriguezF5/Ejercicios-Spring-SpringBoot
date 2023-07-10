package com.example.SpringBootSchool.controller;

import com.example.SpringBootSchool.entity.Student;
import com.example.SpringBootSchool.services.StudentService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StudentController {

    @Autowired
    StudentService studentService;

    @GetMapping("/api/students")
    @Operation(description = "Get a list of students")
    public List<Student> findAll() {
        return studentService.findAll();
    }

    @DeleteMapping("/api/students/")
    @Operation(description = "Delete a list of students")
    public ResponseEntity<Student> deleteAll() {
        return studentService.deleteAll();
    }
}
