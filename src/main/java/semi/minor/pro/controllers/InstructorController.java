package semi.minor.pro.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import semi.minor.pro.dto.ApiResponse;
import semi.minor.pro.dto.InstructorDto;
import semi.minor.pro.services.InstructorService;

@RestController
@RequestMapping("/instructor")
public class InstructorController {
    @Autowired
    InstructorService instructorService;
    @PostMapping("/addorupdateinstructor/{designation}/{courseId}")
    public ApiResponse<ResponseEntity<InstructorDto>> addinstructor(@RequestBody InstructorDto instructorDto, @PathVariable String designation,@PathVariable Integer courseId)
    {
        Boolean isadded=instructorService.add(instructorDto,designation,courseId);
        if(isadded)
        {
            return ApiResponse.success(new ResponseEntity<>(instructorDto, HttpStatus.ACCEPTED));
        }
        else{
            return ApiResponse.failure("failed to create instructor","oops something went wrong");
        }
    }
    @DeleteMapping("/deleteinstructor/{designation}/{id}")
    public ApiResponse<ResponseEntity<Integer>> deleteinstructor(@PathVariable Integer id, @PathVariable String designation)
    {
        Boolean isdeleted=instructorService.deleted(id,designation);
        if(isdeleted)
        {
            return ApiResponse.success(new ResponseEntity<>(id, HttpStatus.ACCEPTED));
        }
        else{
            return ApiResponse.failure("failed to delete instructor","oops something went wrong");
        }
    }





}
