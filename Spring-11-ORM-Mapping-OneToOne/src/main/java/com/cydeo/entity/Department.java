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
    @OneToOne(mappedBy = "department")  // creating bi-directional relationship
    private Employee employee;  // owner is employee table because employee table will have the foreignKey

    public Department(String departmentName, String division) {
        this.departmentName = departmentName;
        this.division = division;
    }
}
