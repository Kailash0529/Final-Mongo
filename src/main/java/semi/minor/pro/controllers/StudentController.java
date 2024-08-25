package semi.minor.pro.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import semi.minor.pro.dto.ApiResponse;
import semi.minor.pro.dto.StudentDto;
import semi.minor.pro.entity.Student;
import semi.minor.pro.services.StudentService;

@RestController
@RequestMapping("/student")
public class StudentController {
    @Autowired
    StudentService studentService;
    @PostMapping("/add/{designation}")
    public ApiResponse<ResponseEntity<StudentDto>>addStudent(@RequestBody StudentDto studentDto, @PathVariable String designation)
    {
        boolean isadded=studentService.add(studentDto,designation);
        if(isadded)
        {
            return ApiResponse.success(new ResponseEntity<>(studentDto, HttpStatus.CREATED));
        }
        else{
            return ApiResponse.failure("REGISTRATION_FAILED","failed to register student");
        }
    }
    @DeleteMapping("/delete/{id}")
    public ApiResponse<ResponseEntity<Integer>>deleteStudent(@PathVariable Integer id)
    {
        boolean isdeleted=studentService.delete(id);
        if (isdeleted)
        {
            return ApiResponse.success(new ResponseEntity<>(id,HttpStatus.ACCEPTED));
        }
        else{
            return ApiResponse.failure("DELETION_FAILED","failed to delete student");

        }
    }





}
