package stereotype_annotation.model;

import org.springframework.stereotype.Component;

@Component
public class DataStructure {

    public void getHours(){
        System.out.println("Total hours: "+ 30);
    }
}
