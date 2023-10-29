package com.cydeo.entity;

import com.cydeo.enums.Gender;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "employees")
@NoArgsConstructor
public class Employee extends BaseEntity{
    private String firstName;
    private String lastName;
    private String email;
    @Column(columnDefinition = "date")
    private LocalDate hireDate;
    @Enumerated(EnumType.STRING)
    private Gender gender;
    private BigDecimal salary;
    private Department department;
    private Region region;
}
