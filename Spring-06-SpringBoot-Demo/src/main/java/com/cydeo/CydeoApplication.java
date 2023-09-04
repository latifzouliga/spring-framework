package com.cydeo;

import com.cydeo.model.Comment;
import com.cydeo.service.CommentService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

// all the 3 annotations are included inside @SpringBootApplication, plus creating a config class
// @SpringBootConfiguration
// @EnableAutoConfiguration
// @ComponentScan
@SpringBootApplication
public class CydeoApplication {


	public static void main(String[] args) {


		Comment comment = new Comment();
		comment.setAuthor("Johnson");
		comment.setText("Spring framework");


		ApplicationContext context = SpringApplication.run(CydeoApplication.class, args);

		CommentService cs = context.getBean(CommentService.class);

		cs.publishComment(comment);


	}

}
