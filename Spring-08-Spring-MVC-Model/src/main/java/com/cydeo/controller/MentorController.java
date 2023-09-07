package com.cydeo.controller;

import com.cydeo.model.Gender;
import com.cydeo.model.Mentor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("mentor")
public class MentorController {

    @RequestMapping("/list") // http://localhost:8099/mentor/list
    public String ShowTable(Model model) {
        mentorData(model);
        return "mentor/mentor-list";
    }

    public void mentorData(Model model) {
        List<Mentor> mentors = new ArrayList<>() {{
            add(new Mentor("Mike", "Smith", 33, Gender.MALE));
            add(new Mentor("Tom", "Hanks", 55, Gender.MALE));
            add(new Mentor("Amy", "Bryan", 35, Gender.FEMALE));
        }};

        //model.addAttribute("mentors",mentors);

        model.addAttribute("firstName", "First Name");
        model.addAttribute("lastName", "Last Name");
        model.addAttribute("age", "Age");
        model.addAttribute("gender", "Gender");

        model.addAttribute("mentor1", mentors.get(0));
        model.addAttribute("mentor2", mentors.get(1));
        model.addAttribute("mentor3", mentors.get(2));
    }
}
