//package semi.minor.pro.services.impl;
//
//
//import org.springframework.beans.BeanUtils;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import semi.minor.pro.constants.UserType;
//import semi.minor.pro.dto.StudentDto;
//import semi.minor.pro.entity.Course;
//import semi.minor.pro.entity.Student;
//import semi.minor.pro.repository.CourseRepository;
//import semi.minor.pro.repository.StudentRepository;
//import semi.minor.pro.services.StudentService;
//
//import java.util.Optional;
//@Service
//public class StudentServiceImpl implements StudentService {
//    @Autowired
//    StudentRepository studentRepository;
//    @Autowired
//    CourseRepository courseRepository;
//    @Override
//    public Boolean add(StudentDto studentDto,String designation) {
//        if(UserType.INSTRUCTOR.toString().toLowerCase().equals(designation))
//        {
//            Student student=new Student();
//            BeanUtils.copyProperties(studentDto,student);
//
//
//           try{
//               studentRepository.save(student);
//               if(courseRepository.findById(studentDto.getCourseId())!=null)
//               {
//                   Course course=new Course();
//                   course=courseRepository.findById(studentDto.getCourseId()).get();
//
//
//               }
//               return true;
//           } catch (Exception e) {
//               e.printStackTrace();
//               return false;
//           }
//        }
//        return false;
//
//
//    }
//    public Boolean delete(Integer id)
//    {
//       try{
//           studentRepository.deleteById(id);
//           return true;
//       } catch (Exception e) {
//           e.printStackTrace();
//           return false;
//       }
//
//
//
//    }
//}
package semi.minor.pro.services.impl;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import semi.minor.pro.constants.UserType;
import semi.minor.pro.dto.StudentDto;
import semi.minor.pro.entity.Course;
import semi.minor.pro.entity.Student;
import semi.minor.pro.repository.CourseRepository;
import semi.minor.pro.repository.StudentRepository;
import semi.minor.pro.services.StudentService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private CourseRepository courseRepository;

    @Override
    public Boolean add(StudentDto studentDto, String designation) {
        // Check if the user type is INSTRUCTOR
        if (UserType.INSTRUCTOR.toString().toLowerCase().equals(designation)) {
            Student student = new Student();
            BeanUtils.copyProperties(studentDto, student);

            try {
                List<Course> studentCourses = new ArrayList<>();

                if (studentDto.getCourseId() != null && !studentDto.getCourseId().isEmpty()) {
                    for (Integer courseId : studentDto.getCourseId()) {
                        Optional<Course> courseOpt = courseRepository.findById(courseId);
                        if (courseOpt.isPresent()) {
                            studentCourses.add(courseOpt.get());  // Add the course to the student's list
                        } else {
                            throw new Exception("Course not found with id: " + courseId);
                        }
                    }
                }

                student.setCourseId(studentCourses);

                studentRepository.save(student);
                return true;

            } catch (Exception e) {
                e.printStackTrace();
                return false;
            }
        }

        return false;
    }

    @Override
    public Boolean delete(Integer id) {
        try {
            studentRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}

