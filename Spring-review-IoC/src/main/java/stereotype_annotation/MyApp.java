package stereotype_annotation;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import stereotype_annotation.config.Config;
import stereotype_annotation.model.DataStructure;

public class MyApp {

    public static void main(String[] args) {

        ApplicationContext container = new  AnnotationConfigApplicationContext(Config.class);
        container.getBean(DataStructure.class).getHours();
    }
}
