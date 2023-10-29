package com.cydeo.entity;

import com.cydeo.enums.Gender;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "employees")
@NoArgsConstructor
@Getter
@ToString
public class Employee extends BaseEntity{
    private String firstName;
    private String lastName;
    private String email;
    @Column(columnDefinition = "date")
    private LocalDate hireDate;
    @Enumerated(EnumType.STRING)
    private Gender gender;
    private BigDecimal salary;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "department")
    private Department department;
    @ManyToOne(fetch = FetchType.LAZY)
    private Region region;
}
