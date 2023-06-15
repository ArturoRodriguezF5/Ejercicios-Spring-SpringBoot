package com.example.SpringBootSchool.controller;

import com.example.SpringBootSchool.entity.Student;
import com.example.SpringBootSchool.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StudentController {

    @Autowired
    StudentService studentService;

    @GetMapping("/api/students")
    public List<Student> findAll() {
        return studentService.findAll();
    }
}
