package semi.minor.pro.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;


@Document
@Data
@Getter
@Setter
public class Course {
    @Id
    Integer courseId;
    String courseName;
    Integer courseFee;
    Integer instructorId;
    List<Integer>studentId;

    public List<Integer> getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId.add(studentId);
    }

    public Integer getCourseId() {
        return courseId;
    }

    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }

    public Integer getInstructorId() {
        return instructorId;
    }

    public void setInstructorId(Integer instructorId) {
        this.instructorId = instructorId;
    }

    public Integer getCourseFee() {
        return courseFee;
    }

    public void setCourseFee(Integer courseFee) {
        this.courseFee = courseFee;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }
}
