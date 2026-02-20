package com.springbootbasics.springBootPractice.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.springbootbasics.springBootPractice.dto.AddStudentDto;
import com.springbootbasics.springBootPractice.dto.StudentDTO;
import com.springbootbasics.springBootPractice.entity.Student;
@Service
public interface StudentService {

    List<StudentDTO> getAllStudents();

    StudentDTO getStudentById(Long studentId);

    StudentDTO createNewStudent(AddStudentDto addnewStudentDto);

    void deleteStudentById(Long studentId);

    StudentDTO updateStudent(Long id, AddStudentDto studentDto);

    StudentDTO updatePartialStudent(Long id, Map<String,Object> updates);

    Student getStudentByIdTest(Long id);

}
