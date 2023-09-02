package bean_practice;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MyApp {

    public static void main(String[] args) {

        ApplicationContext container = new AnnotationConfigApplicationContext(ConfigApp.class);
        container.getBean(FullTimeEmployee.class).createAccount();
        container.getBean(PartTimeEmployee.class).createAccount();
    }
}
