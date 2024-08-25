package semi.minor.pro.entity;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;

@Document
@Data
public class Course {
    @Id
    Integer courseId;
    String courseName;
    Integer courseFee;
}
