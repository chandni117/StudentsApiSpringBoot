package com.springbootbasics.springBootPractice.service.impl;

import java.util.List;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.springbootbasics.springBootPractice.dto.AddStudentDto;
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

    @Override
    public StudentDTO createNewStudent(AddStudentDto addnewStudentDto) {
        Student newStudent = modelMapper.map(addnewStudentDto, Student.class);
        System.out.print("newStudent " + newStudent);
        Student student = studentRepository.save(newStudent);
        return modelMapper.map(student, StudentDTO.class);        
    }

    @Override
    public void deleteStudentById(Long studentId) {
        if(!studentRepository.existsById(studentId))
        {
            throw new IllegalArgumentException("Student does not exist with id" + studentId);
        }
        studentRepository.deleteById(studentId);
        
    }

    @Override
    public StudentDTO updateStudent(Long id, AddStudentDto studentDto) {
        Student student = studentRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Student not found with ID " + id));
        modelMapper.map(studentDto, student);
        student = studentRepository.save(student);
        return modelMapper.map(student, StudentDTO.class); 
    }

}
