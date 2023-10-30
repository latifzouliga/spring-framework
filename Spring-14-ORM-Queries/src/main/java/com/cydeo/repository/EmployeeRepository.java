package com.cydeo.repository;

import com.cydeo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    // Display all employee with email, address, ...
    Employee findByEmail(String email);

    // Display all employees with first name ' ' and last name '  ', also show all employees with email address
    List<Employee> findAllByFirstNameAndLastNameOrEmail(String firstName, String LastName, String email);

    // display all employees that first name is not ' '
    List<Employee> findByFirstNameIsNot(String firstName);

    // Display all employees where last name starts with ' '
    List<Employee> findByLastNameStartingWith(String lastName);

    // Display all employees with salaries higher than ' '
    List<Employee>  findBySalaryGreaterThan(Integer salary);

    // Display all employees with salary less than
    List<Employee> findBySalaryLessThanEqual(Integer salary);

    // display all employees that has been hired between '' and ''
    List<Employee>  findByHireDateBetween(LocalDate startDate, LocalDate endDate);

    // Display all employees where salary greater and equal to '' in desc order
    List<Employee> findBySalaryGreaterThanEqualOrderBySalaryDesc(Integer salary);

    // Display top 3 unique employees that is making less than ''
    List<Employee> findDistinctTop3BySalaryLessThan(Integer salary);

    // Display all employees that don't have email address
    List<Employee> findByEmailIsNull();



























}
