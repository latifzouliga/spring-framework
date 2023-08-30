package com.cydeo;

import com.cydeo.config.ProjectConfig;
import com.cydeo.model.Comment;
import com.cydeo.service.CommentService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class CydeoApp {

    public static void main(String[] args) {

        Comment comment = new Comment();
        comment.setAuthor("Johnson");
        comment.setText("Spring framework");


        ApplicationContext container = new AnnotationConfigApplicationContext(ProjectConfig.class);

        // Proofing that spring is using Singleton
        // Spring is using the default scope Singleton
        CommentService cs1 = container.getBean(CommentService.class);
        CommentService cs2 = container.getBean(CommentService.class);

        System.out.println(cs1);
        System.out.println(cs2);

        // if this line prints true, It is using Singleton else is using prototype
        System.out.println(cs1 == cs2);


        // if we want different objects we need to use prototype scope but we need to manage it by adding @Scope at class level
        // If line 30 is printing false please check line 13 and 14 in CommentService class under cydeo/service package





    }
}
