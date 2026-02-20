package com.springbootbasics.springBootPractice.entity;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Index;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
@Table( name = "student",
    uniqueConstraints = {
        @UniqueConstraint(name = "unique_student_name_email", columnNames = {"name", "email" })
    },
    indexes = {
        @Index(name="idx_std_email" , columnList = "email")
    }
)
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column(unique = true)
    private String email;

    private String gender;

    @CreationTimestamp
    private LocalDateTime createdAt;

}
