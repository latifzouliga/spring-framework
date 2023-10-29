package com.cydeo.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "departments")
@NoArgsConstructor
@Getter
@ToString
public class Department {
    @Id
    private String department;
    private String division;

}
