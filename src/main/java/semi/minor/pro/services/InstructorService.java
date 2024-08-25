package semi.minor.pro.services;

import org.springframework.stereotype.Service;
import semi.minor.pro.dto.InstructorDto;

@Service
public interface InstructorService {
public Boolean add(InstructorDto instructorDto,String designation,Integer courseId);
public Boolean deleted(Integer id,String designation);
}
