package semi.minor.pro.services.impl;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import semi.minor.pro.constants.UserType;
import semi.minor.pro.dto.CourseDto;
import semi.minor.pro.entity.Course;
import semi.minor.pro.repository.CourseRepository;
import semi.minor.pro.services.CourseService;
@Service
public class CourseServiceImpl implements CourseService {
    @Autowired
    CourseRepository courseRepository;
    @Override

    public Boolean addCourse(CourseDto courseDto,String designation)
    {


        if(UserType.INSTRUCTOR.toString().toLowerCase().equals(designation))
        {
            Course course=new Course();
            BeanUtils.copyProperties(courseDto,course);
            try{
                courseRepository.save(course);
                return true;
            } catch (Exception e) {
                e.printStackTrace();

            }
        }
        return false;
    }
    public Boolean delete(Integer id)
    {
        try{
            courseRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
