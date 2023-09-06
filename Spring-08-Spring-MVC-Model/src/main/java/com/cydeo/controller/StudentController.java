package com.cydeo.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@org.springframework.stereotype.Controller
public class StudentController {


    @RequestMapping("/welcome")
    public String homePage(Model model) {

        model.addAttribute("name", "Cydeo");
        model.addAttribute("course", "MVC");


        return "student/welcome";
    }


    @RequestMapping("/latif")
    public String homePage2(Model model) {

        return "student/welcome";
    }

}
