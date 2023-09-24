package com.cydeo.controller;

import com.bootstrap.DataGenerator;
import com.cydeo.model.Employee;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/employee")
public class EmployeeController {

    @GetMapping("/register")
    public String register(Model model) {

        model.addAttribute("employee", new Employee());
        model.addAttribute("states", DataGenerator.getAllStates());

        return "employee/employee-registration";
    }

    @PostMapping("/list")
    public String confirm(@Valid @ModelAttribute("employee") Employee employee, BindingResult bindingResult, Model model) {

        // if there is any error just stay in the same page until the error is fixed
        if (bindingResult.hasErrors()){
            // we don't have to add Employee object her because it is already in the method parameter
            //model.addAttribute("employee", new Employee());
            // But we need to add the states her other because states are in different method, and we don't have access to it
            model.addAttribute("states", DataGenerator.getAllStates());
            return  "employee/employee-registration";
        }

        DataGenerator.saveEmployee(employee);
        model.addAttribute("employees", DataGenerator.readAllEmployees());

        return "employee/employee-confirm";

    }
    //    All validation we added for the fields in the Employee class will not work if we don't add @Valid annotation to PostMapping method
    //    BindingResult interface stops the @PostingMapping from execution if any of the validation did not pass
    //    If we don't use BindingResult the PostMapping method will be executed and the application will crash
    //    BindingResult needs to be placed right next Employee object parameter otherwise bindingResult will not work
}
