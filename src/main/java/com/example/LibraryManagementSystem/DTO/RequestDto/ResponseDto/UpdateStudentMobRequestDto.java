package com.example.LibraryManagementSystem.DTO.RequestDto.ResponseDto;

import com.example.LibraryManagementSystem.Entity.Student;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UpdateStudentMobRequestDto {
    private int id;
    private String mobNo;
}
