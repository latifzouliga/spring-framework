package com.cydeo.bootStrap;

import com.cydeo.entity.Department;
import com.cydeo.entity.Employee;
import com.cydeo.enums.Gender;
import com.cydeo.repository.DepartmentRepository;
import com.cydeo.repository.EmployeeRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class DataGenerator implements CommandLineRunner {

    private final EmployeeRepository employeeRepository;
    private final DepartmentRepository departmentRepository;

    public DataGenerator(EmployeeRepository employeeRepository, DepartmentRepository departmentRepository) {
        this.employeeRepository = employeeRepository;
        this.departmentRepository = departmentRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        List<Employee> employeeList = new ArrayList<>();


        Employee e1 = new Employee("BerrieLatif", "Manueau", "bmanueau0@dion.ne.jp", LocalDate.of(2006, 04, 20), 154864, Gender.F);
        Employee e2 = new Employee("Aeriell", "McNee", "amcnee1@google.es", LocalDate.of(2009, 01, 26), 56752, Gender.F);
        Employee e3 = new Employee("Sydney", "Symonds", "ssymonds2@hhs.gov", LocalDate.of(2010, 05, 17), 95313, Gender.F);
        Employee e4 = new Employee("Avrom", "Rowantree", null, LocalDate.of(2014, 03, 02), 119764, Gender.M);
        Employee e5 = new Employee("Feliks", "Morffew", "fmorffew4@a8.net", LocalDate.of(2003, 01, 14), 55307, Gender.M);
        Employee e6 = new Employee("Zouliga", "Morffew", "fmorffew4@a8.net", LocalDate.of(2003, 01, 14), 55307, Gender.M);

        Department d1 = new Department("Sports", "Outdoors");
        Department d2 = new Department("Tools", "Hardware");
        Department d3 = new Department("Clothing", "Home");
        Department d4 = new Department("Phones & Tablets", "Electronics");
        Department d5 = new Department("Computers", "Electronics");

//        Region r1 = new Region("Southwest","United States");
//        Region r2 = new Region("Central","United States");
//        Region r3 = new Region("Northwest","United States");
//        Region r4 = new Region("Quebec'","Canada");
//        Region r5 = new Region("Central","Asia");

        employeeRepository.save(e1);
        employeeRepository.save(e2);
        employeeRepository.save(e3);
        employeeRepository.save(e4);
        employeeRepository.save(e5);
        employeeRepository.save(e6);

        List<Department> departmentList = new ArrayList<>(Arrays.asList(d1, d2, d3, d4, d5));
        departmentRepository.saveAll(departmentList);


    }
}