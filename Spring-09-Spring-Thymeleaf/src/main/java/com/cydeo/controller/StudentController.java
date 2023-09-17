package com.cydeo.controller;

import com.cydeo.bootstrap.DataGenerator;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/student")
public class StudentController {

    //    @RequestMapping(value = "/register", method = RequestMethod.GET) // before spring 4.3
    @GetMapping("/register")  // after spring 4.3
    public String register(Model model) {

        model.addAttribute("students", DataGenerator.createStudent());
        return "student/register";
    }


    @RequestMapping("/welcome")
    public String info(@RequestParam(required = false) String id, Model model) {

        model.addAttribute("id", id);
        System.out.println(id);
        return "/student/welcome";
    }


}
