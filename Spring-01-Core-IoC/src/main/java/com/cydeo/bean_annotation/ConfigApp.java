package com.cydeo.bean_annotation;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class ConfigApp {

    @Bean
    FullTimeMentor fullTimeMentor(){
        return new FullTimeMentor();
    }

    // if there are multiple beans with the same object, we can add an argument to @Bean annotation
    //@Bean(name = "p1")
    @Bean
    @Primary
    PartTimeMentor partTimeMentor(){
        return new PartTimeMentor();
    }

    //@Bean(name = "p2")
    @Bean
    PartTimeMentor partTimeMentor2(){
        return new PartTimeMentor();
    }

}
