package com.springbootbasics.springBootPractice.service;

import java.util.List;

import org.jspecify.annotations.Nullable;
import org.springframework.stereotype.Service;

import com.springbootbasics.springBootPractice.dto.AddStudentDto;
import com.springbootbasics.springBootPractice.dto.StudentDTO;
@Service
public interface StudentService {

    List<StudentDTO> getAllStudents();

    StudentDTO getStudentById(Long studentId);

    StudentDTO createNewStudent(AddStudentDto addnewStudentDto);

}
