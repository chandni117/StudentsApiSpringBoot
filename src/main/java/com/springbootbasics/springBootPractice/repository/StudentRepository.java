package com.springbootbasics.springBootPractice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.springbootbasics.springBootPractice.entity.Student;

import java.time.LocalDate;
import java.util.List;
import com.springbootbasics.springBootPractice.enums.BloodGroupType;

import jakarta.transaction.Transactional;


@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    //JPQL language
    //Hibernate auto converts JPQL to SQL language
    @Query("SELECT s from Student s where s.bloodGroup=?1")
    List<Student> findByBloodGroup(@Param("bloodGroup") BloodGroupType bloodGroup);

    
    @Query("SELECT s from Student s where s.birthDate>:birthDate")
    List<Student> findByBornAfterDate(@Param("birthDate") LocalDate brthDate);

    @Query("SELECT s.bloodGroup, count(s) from Student s GROUP BY s.bloodGroup")
    List<Object[]> countEachBloodGroupType();

    @Query(value = "SELECT * FROM student" , nativeQuery = true)
    List<Student> findAllStudents();


    @Transactional
    @Modifying
    @Query("UPDATE Student s SET s.name=:name where s.id=:id")
    int updateStudentByName(@Param("name") String name, @Param("id") Long id );
    

}
