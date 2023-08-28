package com.cydeo.stereotype_annotation;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Configuration
@ComponentScan(basePackages = "com.cydeo") // scan all packages under cydeo package
//@ComponentScan // when spring find this annotation, spring will scan all the package for classes annotated with @Component
public class ConfigCourse {
}
