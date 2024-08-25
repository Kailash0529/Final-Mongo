package semi.minor.pro.services.impl;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import semi.minor.pro.constants.UserType;
import semi.minor.pro.dto.CourseDto;
import semi.minor.pro.dto.InstructorDto;
import semi.minor.pro.entity.Course;
import semi.minor.pro.entity.Instructor;
import semi.minor.pro.repository.CourseRepository;
import semi.minor.pro.repository.InstructorRepository;
import semi.minor.pro.services.InstructorService;
@Service
public class InstructorServiceImpl implements InstructorService {
    @Autowired
    InstructorRepository instructorRepository;
    @Autowired
    CourseRepository courseRepository;
    @Override
    public Boolean add(InstructorDto instructorDto,String designation,Integer courseId)
    {
        if(UserType.ADMIN.toString().toLowerCase().equals(designation)){

            Instructor instructor=new Instructor();
            BeanUtils.copyProperties(instructorDto,instructor);

            try{
                instructorRepository.save(instructor);
                if(instructor.getCourseId()!=null)
                {
                    Course course=new Course();
                    course= courseRepository.findById(instructor.getCourseId()).get();
                    if(course!=null)
                    {
                        course.setInstructorId(instructor.getInstructorId());
                    }
                }


                return true;
            } catch (Exception e) {
                e.printStackTrace();
                return false;
            }
        }
        return false;
    }
    @Override
    public Boolean deleted(Integer id,String designation)
    {
        if(UserType.ADMIN.toString().toLowerCase().equals(designation))
        {
            instructorRepository.deleteById(id);
            return true;
        }
        else{
            return false;
        }

    }
}
