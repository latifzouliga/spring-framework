package bean_practice;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MyApp {

    public static void main(String[] args) {

        ApplicationContext container = new AnnotationConfigApplicationContext(ConfigApp.class, ConfigString.class);
        container.getBean(FullTimeEmployee.class).createAccount();
        container.getBean(PartTimeEmployee.class).createAccount();


        //String s = container.getBean(ConfigString.class).str1();

        String s1 = container.getBean(String.class);              //  @Primary
        String s2 = container.getBean("str2",String.class);     // @Bean // uses the method name
        String s3 = container.getBean("string 3",String.class); // @Bean(name = "string 3")

        System.out.println(s1);
        System.out.println(s2);
        System.out.println(s3);


    }
}
