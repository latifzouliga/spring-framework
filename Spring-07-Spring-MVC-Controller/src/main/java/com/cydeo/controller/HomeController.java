package com.cydeo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller // Annotate the class with the @Controller stereotype annotation
public class HomeController {

    @RequestMapping("/home")// to associate the action with an HTTP request path
    public String home(){
        return "home.html"; // returns the HTML document name tht contains the detail we want the browser to display
    }

    @RequestMapping("/welcome")
    public String home2(){
        return "welcome.html";
    }

    @RequestMapping
    public String home3(){
        return "welcome.html";
    }


}
