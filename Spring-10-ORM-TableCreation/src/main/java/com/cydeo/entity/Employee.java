package com.cydeo.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Employee {
    @Id
    private Long id;
    private String firstName;
    private String lastName;
    private String jobTitle;

}
