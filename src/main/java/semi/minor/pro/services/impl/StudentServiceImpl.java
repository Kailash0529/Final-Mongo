package semi.minor.pro.services.impl;


import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import semi.minor.pro.constants.UserType;
import semi.minor.pro.dto.StudentDto;
import semi.minor.pro.entity.Student;
import semi.minor.pro.repository.StudentRepository;
import semi.minor.pro.services.StudentService;

import java.util.Optional;
@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    StudentRepository studentRepository;
    @Override
    public Boolean add(StudentDto studentDto,String designation) {
        if(UserType.INSTRUCTOR.toString().toLowerCase().equals(designation))
        {
            Student student=new Student();
            BeanUtils.copyProperties(studentDto,student);


           try{
               studentRepository.save(student);
               return true;
           } catch (Exception e) {
               e.printStackTrace();
               return false;
           }
        }
        return false;


    }
    public Boolean delete(Integer id)
    {
       try{
           studentRepository.deleteById(id);
           return true;
       } catch (Exception e) {
           e.printStackTrace();
           return false;
       }



    }
}
