package semi.minor.pro.entity;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;

@Document
@Data
public class Instructor {
    @Id
    Integer instructorId;
    String instructorName;
    String instructorDob;
}
