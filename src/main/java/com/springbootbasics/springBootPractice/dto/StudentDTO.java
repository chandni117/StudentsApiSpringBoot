package com.springbootbasics.springBootPractice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentDTO {
    
    Long id;
    String name;
    String email;
    // public StudentDTO(Long id, String name, String email) {
    //     this.id = id;
    //     this.name = name;
    //     this.email = email;
    // }

}
