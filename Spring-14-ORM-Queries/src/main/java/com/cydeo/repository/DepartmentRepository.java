package com.cydeo.repository;

import com.cydeo.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, String> {

    // Display all departments in furniture department
    List<Department> findByDepartment(String department);

    // Display all departments in the health Division
    // all the same
    List<Department> findByDivision(String division);
    List<Department> findByDivisionIs(String division);
    List<Department> findByDivisionEquals(String division);

    // display top 3 departments with division name include 'Hea', without duplicates
    List<Department> findDistinctTop3ByDivisionContaining(String division);
}
