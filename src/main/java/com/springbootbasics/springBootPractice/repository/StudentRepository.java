package com.springbootbasics.springBootPractice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springbootbasics.springBootPractice.entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

}
