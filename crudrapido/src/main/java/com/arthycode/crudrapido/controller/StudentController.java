package com.arthycode.crudrapido.controller;

import com.arthycode.crudrapido.entity.Student;
import com.arthycode.crudrapido.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/v1/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping
    public List<Student> getAll() {
        return studentService.getStudents();
    }

    @GetMapping("/{studentId}")
    public Optional<Student> getStudent(@PathVariable("studentId") Long studentId) {
        return studentService.getStudent(studentId);
    }

    @PostMapping
    public void addOrUpdateStudent(@RequestBody Student student) {
        studentService.saveOrUpdate(student);
    }

    @DeleteMapping("/{studentId}")
    public void deleteByid(@PathVariable("studentId") Long studentId) {
        studentService.delete(studentId);
    }

    @DeleteMapping
    public void deleteAll() {
        studentService.deleteAll();
    }
}
