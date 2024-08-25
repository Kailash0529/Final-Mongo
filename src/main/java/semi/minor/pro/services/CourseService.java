package semi.minor.pro.services;

import org.springframework.stereotype.Service;
import semi.minor.pro.dto.CourseDto;

@Service
public interface CourseService {
    public Boolean addCourse(CourseDto courseDto,String designation);
    public Boolean delete(Integer i);
}
