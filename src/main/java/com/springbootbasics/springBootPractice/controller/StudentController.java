package com.springbootbasics.springBootPractice.controller;

import org.springframework.web.bind.annotation.RestController;

import com.springbootbasics.springBootPractice.dto.StudentDTO;
import com.springbootbasics.springBootPractice.service.StudentService;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@RestController

public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/student")
    public List<StudentDTO> getStudent() {
        return studentService.getAllStudents();
    }

     @GetMapping("/student/{id}")
    public StudentDTO getStudentById(@PathVariable Long id) {
        return studentService.getStudentById(id);
    }
    

}
