package com.cydeo.bootstrap;

import com.cydeo.entity.Department;
import com.cydeo.entity.Employee;
import com.cydeo.entity.Region;
import com.cydeo.repository.CourseRepository;
import com.cydeo.repository.DepartmentRepository;
import com.cydeo.repository.EmployeeRepository;
import com.cydeo.repository.RegionRepository;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
@AllArgsConstructor
@Transactional
public class DataGenerator implements CommandLineRunner {

    private final RegionRepository regionRepository;
    private final DepartmentRepository departmentRepository;
    private final EmployeeRepository employeeRepository;
    private final CourseRepository courseRepository;



    @Override
    public void run(String... args) throws Exception {

        System.out.println("=================== Region =======================");
        List<Region> regionList = regionRepository.findByCountry("Canada");
        regionList.forEach(System.out::println);


        List<Region> regionList1 = regionRepository.findDistinctByCountry("Canada");
        regionList1.forEach(System.out::println);


        System.out.println("\n--------------- Region - containing-------------------");
        List<Region> united = regionRepository.findByCountryContaining("United");
        united.forEach(System.out::println);


        System.out.println("\n--------------- Region - OrderBy-------------------");
        List<Region> orderByCountry = regionRepository.findByCountryContainingOrderByCountry("Asia");
        orderByCountry.forEach(System.out::println);


        System.out.println("\n--------------- Region  - TopBy-------------------");
        List<Region> topByCountry = regionRepository.findTop2ByCountry("Canada");
        topByCountry.forEach(System.out::println);

        System.out.println("\n=================== Department =======================");

        List<Department> findByToysDepartment = departmentRepository.findByDepartment("Toys");
        findByToysDepartment.forEach(System.out::println);

        System.out.println("\n--------------- Division is -------------------");

        List<Department> division = departmentRepository.findByDivisionEquals("Health");
        division.forEach(System.out::println);

        System.out.println("\n--------------- Division - distinct - containing -------------------");
        List<Department> top3 = departmentRepository.findDistinctTop3ByDivisionContaining("Hea");
        top3.forEach(System.out::println);

        System.out.println("\n=================== Employee =======================");

        Employee employeesByEmail = employeeRepository.findByEmail("dtrail8@tamu.edu");
        System.out.println(employeesByEmail);

        System.out.println("\n=================== Employee JPQL =======================");

        System.out.println(employeeRepository.getEmployeeDetail());
        System.out.println(employeeRepository.getEmployeeSalary());

        System.out.println("\n=================== Course =======================");

        courseRepository.findByCategory("Spring").forEach(System.out::println);

        System.out.println("\n------- orderByName ---------");

        courseRepository.findByCategoryOrderByName("Spring").forEach(System.out::println);

        System.out.println("\n------------- exist ---------------");

        System.out.println(courseRepository.existsCourseByName("JavaScript for All"));

        System.out.println("\n------------- count ---------------");

        System.out.println(courseRepository.countByCategory("Spring"));

        System.out.println("\n------------- startingWith ---------------");

        courseRepository.findByNameStartingWith("Scalable").forEach(System.out::println);

        System.out.println("\n=================== Stream =======================");
        courseRepository.streamByCategory("Spring").forEach(System.out::println);

        System.out.println("\n=================== JPQL - NotEqual =======================");
        //System.out.println(employeeRepository.getEmployeeSalaryNotEqual(154864));

        System.out.println("\n=================== Departments - String... =======================");
        departmentRepository.getDepartmentDivision("Kids","Fashion","Health").forEach(System.out::println);

        System.out.println("\n=================== Departments - List =======================");
        departmentRepository.getDepartmentDivision2(List.of("Kids","Fashion","Health")).forEach(System.out::println);

        System.out.println("\n=================== Native SQL Query =======================");

        employeeRepository.readEmployeeDetailBySalary(154864).forEach(System.out::println);

        System.out.println("\n=================== naming param Query =======================");
        courseRepository.findAllByCategoryAndRatingGreaterThan("Spring",3).forEach(System.out::println);

        System.out.println("\n=================== update =======================");
        //employeeRepository.updateEmployeeJPQL(1);
        employeeRepository.updateEmployeeNativeQuery(4);

        System.out.println("\n=================== named Queries =======================");
        departmentRepository.retrieveDepartmentByDivision("Grocery").forEach(System.out::println);


    }


}
