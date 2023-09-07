package com.cydeo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/car")
public class CarController {

    @RequestMapping("/info") // http://localhost:8099/car/info?make=Honda&year=2015
    public String carInfo(@RequestParam String make,@RequestParam Integer year, Model model){

        model.addAttribute("make",make);
        model.addAttribute("year",year);

        return "car/car-info";
    }

    @RequestMapping("/info2") // http://localhost:8099/car/info?make=Honda
    public String carInfo2(@RequestParam(defaultValue = "Tesla") String make, Model model){

        model.addAttribute("make",make);

        return "car/car-info";
    }

    @RequestMapping("/info3/{make}/{year}") // http://localhost:8099/car/info3/toyota/2020
    public String getCarInfo(@PathVariable String make,@PathVariable Integer year, Model model){
        model.addAttribute("make", make);
        model.addAttribute("year", year);
        return "car/car-info";
    }
}
















