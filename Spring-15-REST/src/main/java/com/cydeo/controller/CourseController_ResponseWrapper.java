package com.cydeo.controller;


import com.cydeo.entity.ResponseWrapper;
import com.cydeo.service.CourseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/courses/api/v3")
public class CourseController_ResponseWrapper {

    public CourseController_ResponseWrapper(CourseService courseService) {
        this.courseService = courseService;
    }

    private final CourseService courseService;

    @GetMapping
    public ResponseEntity<ResponseWrapper> getAllCourses(){
        return ResponseEntity
                .status(HttpStatus.ACCEPTED)
                .header("Version","Cydeo.V2")
                .body(new ResponseWrapper("successfully retrieved",courseService.getCourses()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseWrapper> getById(@PathVariable("id") Long id){
        return ResponseEntity.ok(new ResponseWrapper(
                "course: " + id + " retrieved",courseService.getCourseById(id))
        );
    }
}
