package com.cydeo.service;

import com.cydeo.repository.EmployeeRepository;
import com.cydeo.repository.HoursRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;


@Component
public class SalaryService {

    EmployeeRepository employeeRepository;
    HoursRepository hoursRepository;

    public SalaryService(EmployeeRepository employeeRepository, @Qualifier("regular") HoursRepository hoursRepository) {
        this.employeeRepository = employeeRepository;
        this.hoursRepository = hoursRepository;
    }

    public void calculateRegularSalary(){
       int salary = employeeRepository.getHourlyRate() * hoursRepository.getHours();
        System.out.println(salary);
    }
}
