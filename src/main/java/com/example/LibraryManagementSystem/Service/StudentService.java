package com.example.LibraryManagementSystem.Service;

import com.example.LibraryManagementSystem.DTO.RequestDto.ResponseDto.AuthorResponseDto;
import com.example.LibraryManagementSystem.DTO.RequestDto.ResponseDto.StudentRequestDto;
import com.example.LibraryManagementSystem.DTO.RequestDto.ResponseDto.UpdateStudentMobNoResponseDto;
import com.example.LibraryManagementSystem.DTO.RequestDto.ResponseDto.UpdateStudentMobRequestDto;
import com.example.LibraryManagementSystem.Entity.Student;
import com.example.LibraryManagementSystem.Exceptions.StudentNotFoundException;

public interface StudentService {

    public String addStudent(StudentRequestDto studentRequestDto);
    public UpdateStudentMobNoResponseDto updateMob(UpdateStudentMobRequestDto updateStudentMobRequestDto) throws StudentNotFoundException;

    public Student getStudentById(int id);

}
