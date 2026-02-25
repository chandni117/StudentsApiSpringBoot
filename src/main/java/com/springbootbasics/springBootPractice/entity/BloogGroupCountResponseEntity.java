package com.springbootbasics.springBootPractice.entity;

import com.springbootbasics.springBootPractice.enums.BloodGroupType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Data
public class BloogGroupCountResponseEntity {
    private BloodGroupType bloodGroupType;
    private Long count;

}
