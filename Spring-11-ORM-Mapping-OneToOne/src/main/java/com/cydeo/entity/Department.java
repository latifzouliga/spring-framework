package com.cydeo.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@Data
@Entity
@Table(name = "Departments")
public class Department extends BaseEntity{

    private String departmentName;
    private String division;

    public Department(String departmentName, String division) {
        this.departmentName = departmentName;
        this.division = division;
    }
}
