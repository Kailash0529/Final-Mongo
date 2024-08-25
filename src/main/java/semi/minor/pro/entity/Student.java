package semi.minor.pro.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

//import javax.persistence.Entity;

import java.io.Serializable;
import java.util.List;

@Document(collection = "student")
@Data
public class Student implements Serializable {
    @Id
    Integer studentId;
    String studentName;
    String studentDob;

@DBRef
    List<Course>courseId;

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

    public List<Course> getCourseId() {
        return courseId;
    }

    public void setCourseId(List<Course> courseId) {
        this.courseId = courseId;
    }
}
