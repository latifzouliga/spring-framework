package com.cydeo;

import com.cydeo.config.ProjectConfig;
import com.cydeo.model.Comment;
import com.cydeo.proxy.EmailCommentNotificationProxy;
import com.cydeo.repository.DBCommentRepository;
import com.cydeo.service.CommentService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class CydeoApp {

    public static void main(String[] args) {

        Comment comment = new Comment();
        comment.setAuthor("Johnson");
        comment.setText("Spring framework");


        ApplicationContext container = new AnnotationConfigApplicationContext(ProjectConfig.class);

        container.getBean(CommentService.class).publishComment(comment);





    }
}
