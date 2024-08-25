package semi.minor.pro.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import semi.minor.pro.dto.ApiResponse;
import semi.minor.pro.dto.CourseDto;
import semi.minor.pro.dto.StudentDto;
import semi.minor.pro.services.CourseService;
import semi.minor.pro.services.StudentService;

@RestController
@RequestMapping("/course")
public class CourseController {
    @Autowired
    CourseService courseService;
    @PostMapping("/addorupdatecourse/{designation}")
    public ApiResponse<ResponseEntity<CourseDto>> addStudent(@RequestBody CourseDto courseDto, @PathVariable String designation)
    {
        boolean isadded=courseService.addCourse(courseDto,designation);
        if(isadded)
        {
            return ApiResponse.success(new ResponseEntity<>(courseDto, HttpStatus.CREATED));
        }
        else{
            return ApiResponse.failure("REGISTRATION_FAILED","failed to register student");
        }
    }
    @DeleteMapping("/delete/{id}")
    public ApiResponse<ResponseEntity<Integer>>deleteStudent(@PathVariable Integer id)
    {
        boolean isdeleted=courseService.delete(id);
        if (isdeleted)
        {
            return ApiResponse.success(new ResponseEntity<>(id,HttpStatus.ACCEPTED));
        }
        else{
            return ApiResponse.failure("DELETION_FAILED","failed to delete student");

        }
    }

}
