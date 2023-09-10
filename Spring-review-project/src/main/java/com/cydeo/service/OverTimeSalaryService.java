package com.cydeo.service;

import com.cydeo.repository.EmployeeRepository;
import com.cydeo.repository.HoursRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class OverTimeSalaryService{

    EmployeeRepository employeeRepository;
    HoursRepository hoursRepository;

    public OverTimeSalaryService(EmployeeRepository employeeRepository,@Qualifier("OTH") HoursRepository hoursRepository) {
        this.employeeRepository = employeeRepository;
        this.hoursRepository = hoursRepository;
    }

    public void calculateOvertimeSalary(){
        System.out.println(hoursRepository.getHours()*employeeRepository.getHourlyRate());
    }
}
