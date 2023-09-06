package com.cydeo.controller;

import com.cydeo.model.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Controller
public class StudentController {


    @RequestMapping("/welcome")
    public String homePage(Model model) {

        model.addAttribute("name", "Cydeo");
        model.addAttribute("course", "MVC");

        String subject = "Collections";
        model.addAttribute("subject", subject);

        // create some student id and show in UI

        model.addAttribute("student_id_1", 203);
        model.addAttribute("student_id_2", 99);
        model.addAttribute("student_id_3", 3);
        model.addAttribute("student_id_4", 26);

        Random random = new Random();
        model.addAttribute("myId",random.nextInt(1000));

        List<Integer> numbers = new ArrayList<>(){{
            add(random.nextInt(1000));
            add(random.nextInt(1000));
            add(random.nextInt(1000));
            add(random.nextInt(1000));
            add(random.nextInt(1000));
        }};
        model.addAttribute("numbers", numbers);

        Student student = new Student(1,"Mike","Smith");
        model.addAttribute("student",student);

        return "student/welcome";
    }


    @RequestMapping("/latif")
    public String homePage2(Model model) {

        return "student/welcome";
    }

}
