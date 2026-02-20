package com.springbootbasics.springBootPractice.service.impl;

import java.util.List;
import java.util.Map;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.springbootbasics.springBootPractice.dto.AddStudentDto;
import com.springbootbasics.springBootPractice.dto.StudentDTO;
import com.springbootbasics.springBootPractice.entity.Student;
import com.springbootbasics.springBootPractice.repository.StudentRepository;
import com.springbootbasics.springBootPractice.service.StudentService;

import jakarta.transaction.Transactional;
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
        Student student = studentRepository.findById(studentId)
                .orElseThrow(() -> new IllegalArgumentException("Student not found with ID " + studentId));

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
        if (!studentRepository.existsById(studentId)) {
            throw new IllegalArgumentException("Student does not exist with id" + studentId);
        }
        studentRepository.deleteById(studentId);

    }

    @Override
    public StudentDTO updateStudent(Long id, AddStudentDto studentDto) {
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Student not found with ID " + id));
        modelMapper.map(studentDto, student);
        student = studentRepository.save(student);
        return modelMapper.map(student, StudentDTO.class);
    }

    @Override
    public StudentDTO updatePartialStudent(Long id, Map<String, Object> updates) {
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Student not found with ID " + id));

        updates.forEach((field, value) -> {
            switch(field){
                case "name":
                    student.setName((String) value);
                    break;
                case "email":
                    student.setEmail((String) value);
                    break;
                default: 
                    throw new IllegalArgumentException("Inapropriate field");

            }
        });

         Student updatedStudent = studentRepository.save(student);
        return modelMapper.map(updatedStudent, StudentDTO.class);

    }

    @Transactional
    public Student getStudentByIdTest(Long id)
    {
        //hibernate creates select query 2 times because without transactional it creates separate persistent Context for each repository call but 
        // when we add Transactional it creates one time query and persistent context is used to 
        // check whether this entiy with same primary key is already there. No need to do query from database. 
        // It is already in persistent State of Entity Lifecycle, commit and rollback would be done automatically
        Student s1 = studentRepository.findById(id).orElseThrow();

        Student s2 = studentRepository.findById(id).orElseThrow();

        s1.setName("honey");

        
        //here performed dirty checking and automatically changes done
        //studentRepository.save(s1);
        return s1;
    }

}
