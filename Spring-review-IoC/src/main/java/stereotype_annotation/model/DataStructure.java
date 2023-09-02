package stereotype_annotation.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Data
public class DataStructure {

    @NonNull // this field is required. please add it  to constructor
    ExtraHours extraHours;


    public void getHours() {
        System.out.println("Total hours: " + (30 + extraHours.getHours()));
    }
}
