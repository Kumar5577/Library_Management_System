package com.example.LibraryManagementSystem.DTO.RequestDto.ResponseDto;

import com.example.LibraryManagementSystem.Enums.Department;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class StudentRequestDto {
    private String name;
    private int age;
    private Department department;
    private String mobNo;

}
