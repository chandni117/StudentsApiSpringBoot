package com.springbootbasics.springBootPractice.controller;

import org.springframework.web.bind.annotation.RestController;

import com.springbootbasics.springBootPractice.dto.AddStudentDto;
import com.springbootbasics.springBootPractice.dto.StudentDTO;
import com.springbootbasics.springBootPractice.service.StudentService;

import jakarta.servlet.http.HttpServletRequest;

import java.util.List;

import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/students")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public ResponseEntity<List<StudentDTO>> getStudent() {
        // to get status code, body and header with response
        // return
        // ResponseEntity.status(HttpStatus.OK).body(studentService.getAllStudents());
        return ResponseEntity.ok(studentService.getAllStudents());
    }

    @GetMapping("/{id}")
    public ResponseEntity<StudentDTO> getStudentById(@PathVariable Long id) {
        return ResponseEntity.ok(studentService.getStudentById(id));
    }

    @PostMapping
    public ResponseEntity<StudentDTO> createNewStudent(@RequestBody AddStudentDto addnewStudentDto,
            HttpServletRequest request) {
        System.out.println("Content-Type: " + request.getContentType());
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(studentService.createNewStudent(addnewStudentDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStudentById(@PathVariable("id") Long studentId){
        studentService.deleteStudentById(studentId);
        return ResponseEntity.noContent().build();
    }

}
