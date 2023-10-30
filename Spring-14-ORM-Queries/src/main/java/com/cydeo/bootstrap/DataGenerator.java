package com.cydeo.bootstrap;

import com.cydeo.entity.Department;
import com.cydeo.entity.Employee;
import com.cydeo.entity.Region;
import com.cydeo.repository.DepartmentRepository;
import com.cydeo.repository.EmployeeRepository;
import com.cydeo.repository.RegionRepository;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class DataGenerator implements CommandLineRunner {

    private final RegionRepository regionRepository;
    private final DepartmentRepository departmentRepository;
    private final EmployeeRepository employeeRepository;
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


    }


}
