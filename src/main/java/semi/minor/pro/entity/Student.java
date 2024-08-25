package semi.minor.pro.entity;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;
@Entity
@Document
@Data
public class Student implements Serializable {
    @Id
    Integer studentId;
    String studentName;
    String studentDob;
}
