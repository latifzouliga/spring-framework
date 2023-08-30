package com.cydeo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigCar {

    @Bean
    Car car(){
        Car c = new Car();
        c.setMake("Honda");
        return c;
    }

    // Direct wiring
    // by passing an object to the setter of another object
//    @Bean
//    Person person(){
//        Person p = new Person();
//        p.setName("Mike");
//        p.setCar(car()); // wiring. Now the person object has a car
//        return p;
//    }

    // Autowiring
    // passing an object as parameter to the method and then passing it to the setter of another object
    @Bean
    Person person(Car car){
        Person p = new Person();
        p.setName("Mike");
        p.setCar(car); // Autowiring. passing a value
        return p;
    }
}
