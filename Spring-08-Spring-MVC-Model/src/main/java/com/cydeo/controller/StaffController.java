package com.cydeo.controller;

import com.cydeo.model.Gender;
import com.cydeo.model.Mentor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/staff")
public class StaffController {

    @RequestMapping("/list")  // http://localhost:8099/staff/list
    public String showTable(Model model) {
        List<Mentor> mentors = new ArrayList<>() {{
            add(new Mentor("John", "Smith", 45, Gender.MALE));
            add(new Mentor("Kom", "Janks", 65, Gender.MALE));
            add(new Mentor("Amanda", "Baker", 25, Gender.FEMALE));
        }};

        //model.addAttribute("mentors",mentors);

        model.addAttribute("firstName", "First Name");
        model.addAttribute("lastName", "Last Name");
        model.addAttribute("age", "Age");
        model.addAttribute("gender", "Gender");

        model.addAttribute("mentor1", mentors.get(0));
        model.addAttribute("mentor2", mentors.get(1));
        model.addAttribute("mentor3", mentors.get(2));

        return "mentor/mentor-list";
    }
}
