package semi.minor.pro.dto;

import lombok.Data;

import javax.persistence.Id;
import java.util.List;

@Data

public class StudentDto {
    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getStudentDob() {
        return studentDob;
    }

    public void setStudentDob(String studentDob) {
        this.studentDob = studentDob;
    }



    @Id
    Integer studentId;
    String studentName;


    public List<Integer> getCourseId() {
        return courseId;
    }

    public void setCourseId(List<Integer> courseIds) {
        this.courseId = courseIds;
    }

    String studentDob;
    private List<Integer> courseId;

}
