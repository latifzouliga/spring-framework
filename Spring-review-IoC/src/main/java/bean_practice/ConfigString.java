package bean_practice;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class ConfigString {

   //@Bean(name = "s")
    @Bean
    @Primary
    public String str1(){
        return "Welcome to Cydeo";
    }

    @Bean
    public String str2(){
        return "Spring Core Practice";
    }

    @Bean(name = "string 3")
    public String str3(){
        return "My Own Practice Method";
    }
}
