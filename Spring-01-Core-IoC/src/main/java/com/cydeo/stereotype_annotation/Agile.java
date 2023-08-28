package com.cydeo.stereotype_annotation;

import org.springframework.stereotype.Component;

@Component
public class Agile {

    public void getTeachingHours(){
        System.out.println("Total teaching hours : 15");
    }

    public Integer getRealTeachingHours(){
        System.out.print("Sorry, the total teaching hours is : ");
        return 35;
    }
}
