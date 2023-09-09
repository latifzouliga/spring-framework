package com.cydeo;


import com.cydeo.config.EmployeeConfig;
import com.cydeo.service.OverTimeSalaryService;
import com.cydeo.service.SalaryService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MyApp {

    public static void main(String[] args) {

        ApplicationContext context = new AnnotationConfigApplicationContext(EmployeeConfig.class);

        SalaryService service = context.getBean(SalaryService.class);
        service.calculateRegularSalary();

        OverTimeSalaryService overtimeSalaryService = context.getBean(OverTimeSalaryService.class);
        overtimeSalaryService.calculateOvertimeSalary();

    }
}
