package com.cydeo.controller;

import com.cydeo.dto.CourseDTO;
import com.cydeo.service.CourseService;
import org.springframework.web.bind.annotation.*;

import java.util.List;


//@Controller
@RestController // @Controller + @ ResponseBody
@RequestMapping("/courses")
public class CourseController {

    private final CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    //@ResponseBody // not needed
    @GetMapping
    public List<CourseDTO> getAllCourse(){
        return courseService.getCourses();
    }

    //@ResponseBody
    @GetMapping("/{id}")
    public CourseDTO getCourseById(@PathVariable("id") Long id){
        return courseService.getCourseById(id);
    }

    @GetMapping("category/{name}")
    public List<CourseDTO> getCourseByCategory(@PathVariable("name") String name){
        return courseService.getCoursesByCategory(name);
    }
}




















