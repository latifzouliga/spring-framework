package com.cydeo.repository;

import com.cydeo.entity.Department;
import com.cydeo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
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

    @Query("SELECT d FROM Department d WHERE d.division IN (?1)")
    List<Department> getDepartmentDivision(String... division);

    @Query("SELECT d FROM Department d WHERE d.division IN (?1)")
    List<Department> getDepartmentDivision2(List<String> division);

    //============================ Named Queries =========================

    @Query
    List<Department> retrieveDepartmentByDivision(String division);
    @Query(nativeQuery = true)
    List<Department> retrieveDepartmentByDivisionContains(String pattern);


}



















