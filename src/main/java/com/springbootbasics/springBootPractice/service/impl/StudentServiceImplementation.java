package com.springbootbasics.springBootPractice.service.impl;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.springbootbasics.springBootPractice.dto.StudentDTO;
import com.springbootbasics.springBootPractice.entity.Student;
import com.springbootbasics.springBootPractice.repository.StudentRepository;
import com.springbootbasics.springBootPractice.service.StudentService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class StudentServiceImplementation implements StudentService {

    private final StudentRepository studentRepository;
    private final ModelMapper modelMapper;

    @Override
    public List<StudentDTO> getAllStudents() {
        List<Student> listOfStudents = studentRepository.findAll();
        return listOfStudents
        .stream()
        .map(student -> new StudentDTO(student.getId(), student.getName(), student.getEmail()))
        .toList();
    }

    @Override
    public StudentDTO getStudentById(Long studentId) {
        Student student = studentRepository.findById(studentId).orElseThrow(() -> new IllegalArgumentException("Student not found with ID " + studentId)); 

        return modelMapper.map(student, StudentDTO.class);
       
    }

}
