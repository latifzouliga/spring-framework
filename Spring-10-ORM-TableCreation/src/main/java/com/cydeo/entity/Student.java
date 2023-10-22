package com.cydeo.entity;

import com.cydeo.enums.Gender;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Entity  // creates table
@Table(name = "Students") // rename table
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // generate primary key
    private Long id;
    @Column(name = "studentFirstName",length = 100) // rename column and specifying name length
    private String firstName;
    @Column(name = "StudentLastName")
    private String lastName;
    private String email;

    @Transient    // this field will not persist in database
    private String city;
    @Column(columnDefinition = "Date") // gives datatype as Date
    private LocalDate birthdate;
    @Column(columnDefinition = "Time")
    private LocalTime birthTime;
    @Column(columnDefinition = "TimeStamp")
    private LocalDateTime birthDateTime;
    @Enumerated(EnumType.STRING)  // convert column datatype from Integer to varchar
    private Gender gender;
    private Boolean graduated;


}
