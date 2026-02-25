package com.springbootbasics.springBootPractice;

import java.time.LocalDate;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.springbootbasics.springBootPractice.entity.Student;
import com.springbootbasics.springBootPractice.enums.BloodGroupType;
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

        @Test
        public void findStudentByBloodGroup(){
            List<Student> students = studentRepository.findByBloodGroup(BloodGroupType.B_POSITIVE);

            for(Student s : students){
                System.out.println(s);
            }
        }

        @Test
        public void findStudentByBornAfterDate(){
            List<Student> students = studentRepository.findByBornAfterDate(LocalDate.of(1998, 02, 19));

            for(Student s : students){
                System.out.println(s);
            }
        }


        @Test
        public void countStudentByBloodGroup(){
            List<Object[]> studentsList = studentRepository.countEachBloodGroupType();

            for(Object[] s : studentsList){
                System.out.println(s[0] + " " + s[1]);
            }
        }

        @Test
        public void findStudents(){
            List<Student> studentsList = studentRepository.findAllStudents();

            for(Student s : studentsList){
                System.out.println(s);
            }
        }

        @Test
        public void updateStudentByName(){
            int rows= studentRepository.updateStudentByName("chikuuu", 3L);

            System.out.println(rows);
        }

        

}
