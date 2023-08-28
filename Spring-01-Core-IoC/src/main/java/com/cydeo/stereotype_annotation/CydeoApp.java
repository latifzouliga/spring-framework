package com.cydeo.stereotype_annotation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class CydeoApp {

    public static void main(String[] args) {

        // we need to create a container and pass to it config class to let spring to that class
        // spring will look for @Configuration to make sure it is the correct config class
        // spring also will lok for @ComponentScan annotation and scan the whole package for any class that has @component annotation to create and manage beans
        ApplicationContext context = new AnnotationConfigApplicationContext(ConfigCourse.class);

        Agile courseHours = context.getBean(Agile.class);
        courseHours.getTeachingHours();
        System.out.println(courseHours.getRealTeachingHours());

        context.getBean(Java.class).getTeachingHours();


    }

}
