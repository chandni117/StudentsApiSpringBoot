package com.springbootbasics.springBootPractice;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.springbootbasics.springBootPractice.entity.Student;
import com.springbootbasics.springBootPractice.repository.StudentRepository;
import com.springbootbasics.springBootPractice.service.StudentService;

@SpringBootTest
public class StudentTests {
         @Autowired
        private StudentRepository studentRepository;

        @Autowired
        private StudentService studentService;

        @Test
        public void getAllStudents() {
            List<Student> students = studentRepository.findAll();
            System.out.print(students);
        }

        @Test
        public void getStudentById() {
            Student student = studentService.getStudentByIdTest(34L);
            System.out.print(student);
        }
}
