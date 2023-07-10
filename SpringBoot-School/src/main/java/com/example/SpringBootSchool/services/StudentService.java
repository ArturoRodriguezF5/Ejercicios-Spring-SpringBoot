package com.example.SpringBootSchool.services;

import com.example.SpringBootSchool.entity.Student;
import com.example.SpringBootSchool.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    StudentRepository studentRepository;

    public List<Student> findAll() {
        return studentRepository.findAll();
    }
    public ResponseEntity<Student> deleteAll() {
        studentRepository.deleteAll();
        return ResponseEntity.accepted().build();
    }
}
