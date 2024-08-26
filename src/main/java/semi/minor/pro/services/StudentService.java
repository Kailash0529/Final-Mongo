package semi.minor.pro.services;

import org.springframework.stereotype.Service;
import semi.minor.pro.dto.StudentDto;
import semi.minor.pro.entity.Student;
@Service
public interface StudentService {
    public Boolean add(StudentDto studentDto,String designation);
    public Boolean delete(Integer i);
}
