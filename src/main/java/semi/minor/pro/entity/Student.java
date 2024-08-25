package semi.minor.pro.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

//import javax.persistence.Entity;

import java.io.Serializable;

@Document(collection = "student")
@Data
public class Student implements Serializable {
    @Id
    Integer studentId;
    String studentName;
    String studentDob;
}
