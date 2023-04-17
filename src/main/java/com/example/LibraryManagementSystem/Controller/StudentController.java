package com.example.LibraryManagementSystem.Controller;

import com.example.LibraryManagementSystem.DTO.RequestDto.ResponseDto.StudentRequestDto;
import com.example.LibraryManagementSystem.DTO.RequestDto.ResponseDto.UpdateStudentMobNoResponseDto;
import com.example.LibraryManagementSystem.DTO.RequestDto.ResponseDto.UpdateStudentMobRequestDto;
import com.example.LibraryManagementSystem.Entity.Student;
import com.example.LibraryManagementSystem.Exceptions.StudentNotFoundException;
import com.example.LibraryManagementSystem.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/student")
public class StudentController {
    @Autowired
    StudentService studentService;
    @PostMapping(value = "/add")
    public String addStudent(@RequestBody StudentRequestDto studentRequestDto){
        return studentService.addStudent(studentRequestDto);

        // Delete a student by id
        // update a student buy id

        // find all the students

    }
    @PutMapping("/update_mobile")
    public UpdateStudentMobNoResponseDto updateMob(@RequestBody UpdateStudentMobRequestDto updateStudentMobRequestDto) throws StudentNotFoundException {

        return studentService.updateMob(updateStudentMobRequestDto);

    }
    // find a student by id
    @GetMapping("/get_student")
    public Student getStudent(@RequestParam("id") int id){
        return studentService.getStudentById(id);
    }
}
