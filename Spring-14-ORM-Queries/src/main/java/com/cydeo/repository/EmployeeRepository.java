package com.cydeo.repository;

import com.cydeo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;


import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    //============================ Derived Queries =========================

    // Display all employee with email, address, ...
    Employee findByEmail(String email);

    // Display all employees with first name ' ' and last name '  ', also show all employees with email address
    List<Employee> findAllByFirstNameAndLastNameOrEmail(String firstName, String LastName, String email);

    // display all employees that first name is not ' '
    List<Employee> findByFirstNameIsNot(String firstName);

    // Display all employees where last name starts with ' '
    List<Employee> findByLastNameStartingWith(String lastName);

    // Display all employees with salaries higher than ' '
    List<Employee> findBySalaryGreaterThan(Integer salary);

    // Display all employees with salary less than
    List<Employee> findBySalaryLessThanEqual(Integer salary);

    // display all employees that has been hired between '' and ''
    List<Employee> findByHireDateBetween(LocalDate startDate, LocalDate endDate);

    // Display all employees where salary greater and equal to '' in desc order
    List<Employee> findBySalaryGreaterThanEqualOrderBySalaryDesc(Integer salary);

    // Display top 3 unique employees that is making less than ''
    List<Employee> findDistinctTop3BySalaryLessThan(Integer salary);

    // Display all employees that don't have email address
    List<Employee> findByEmailIsNull();


    //============================ JPQL Queries =========================

    @Query("select e FROM Employee e where e.email='sdubber7@t-online.de'")
    Employee getEmployeeDetail();

    @Query("SELECT e.salary FROM Employee e WHERE e.email='sdubber7@t-online.de'")
    Integer getEmployeeSalary();

    @Query("SELECT e FROM Employee e WHERE e.email=?1")
    Optional<Employee> getEmployeeDetail(String email);

    @Query("SELECT e FROM Employee e WHERE e.email=?1 AND e.salary=?2")
    Optional<Employee> getEmployeeDetail(String email, Integer salary);

    // Not Equal
    @Query("SELECT e.salary FROM Employee e WHERE e.salary <> ?1")
    List<Integer> getEmployeeSalaryNotEqual(int salary);

    // like/contains/startWith/endsWith

    // like
    @Query("SELECT e FROM Employee e WHERE e.firstName LIKE ?1")
    List<Employee> getEmployeeFirstNameLike(String pattern);

    // contains
    //@Query("SELECT e FROM Employee e WHERE e.firstName LIKE %?1%")

    // less than
    @Query("SELECT e FROM Employee e WHERE e.salary < ?1")
    List<Employee> getEmployeeSalaryLessThan(int salary);

    // greater than
    @Query("SELECT e FROM Employee e WHERE e.salary > ?1")
    List<Employee> getEmployeeSalaryGreaterThan(int salary);

    // between
    @Query("SELECT e FROM Employee e WHERE e.salary BETWEEN ?1 AND ?2")
    List<Employee> getEmployeeSalaryBetween(int salary1, int salary2);

    // before
    @Query("SELECT e FROM Employee e WHERE e.hireDate > ?1")
    List<Employee> getEmployeeHiredDateBefore(LocalDate date);

    // Null
    @Query("SELECT e FROM Employee e WHERE e.email IS NULL ")
    List<Employee> getEmployeeEmailIsNull();


    // Null
    @Query("SELECT e FROM Employee e WHERE e.email IS NOT NULL ")
    List<Employee> getEmployeeEmailIsNotNull();

    // Sorting in ASC order
    @Query("SELECT e FROM Employee e ORDER BY e.salary")
    List<Employee> getEmployeeSalaryOrderAsc();

    // Sorting in DESC order
    @Query("SELECT e FROM Employee e ORDER BY e.salary DESC")
    List<Employee> getEmployeeSalaryOrderDesc();


    //============================ Native SQL Queries =========================

    @Query(value = "SELECT * FROM employees WHERE salary = ?1", nativeQuery = true)
    List<Employee> readEmployeeDetailBySalary(int salary);

    //============================ Named Parameters =========================

    @Query("SELECT e FROM Employee e WHERE e.salary = :salary")
    List<Employee> getEmployeeSalary(@Param("salary") int salary);

    @Modifying
    @Transactional
    @Query("UPDATE Employee e SET e.email = 'zoul@yahoo.com' WHERE e.id = :id")
    void updateEmployeeJPQL(@Param("id") int id);


    @Modifying
    @Transactional
    @Query(value = "UPDATE Employees SET email = 'zoul@yahoo.com' WHERE id = :id", nativeQuery = true)
    void updateEmployeeNativeQuery(@Param("id") int id);






}











