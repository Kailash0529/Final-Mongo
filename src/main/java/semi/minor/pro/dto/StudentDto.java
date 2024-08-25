package semi.minor.pro.dto;

import lombok.Data;

import javax.persistence.Id;
@Data

public class StudentDto {
    @Id
    Integer studentId;
    String studentName;
    String studentDob;

}
