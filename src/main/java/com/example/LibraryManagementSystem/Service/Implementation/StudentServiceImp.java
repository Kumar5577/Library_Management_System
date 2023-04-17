package com.example.LibraryManagementSystem.Service.Implementation;

import com.example.LibraryManagementSystem.DTO.RequestDto.ResponseDto.AuthorResponseDto;
import com.example.LibraryManagementSystem.DTO.RequestDto.ResponseDto.StudentRequestDto;
import com.example.LibraryManagementSystem.DTO.RequestDto.ResponseDto.UpdateStudentMobNoResponseDto;
import com.example.LibraryManagementSystem.DTO.RequestDto.ResponseDto.UpdateStudentMobRequestDto;
import com.example.LibraryManagementSystem.Entity.Author;
import com.example.LibraryManagementSystem.Entity.Card;
import com.example.LibraryManagementSystem.Entity.Student;
import com.example.LibraryManagementSystem.Enums.CardStatus;
import com.example.LibraryManagementSystem.Exceptions.StudentNotFoundException;
import com.example.LibraryManagementSystem.Repository.AuthorRepository;
import com.example.LibraryManagementSystem.Repository.StudentRepository;
import com.example.LibraryManagementSystem.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImp implements StudentService {
    @Autowired
    StudentRepository studentRepository;

    @Override
    public String addStudent(StudentRequestDto studentRequestDto){

        Student student = new Student();
        student.setAge(studentRequestDto.getAge());
        student.setName(studentRequestDto.getName());
        student.setDepartment(studentRequestDto.getDepartment());
        student.setMobNo(studentRequestDto.getMobNo());


        Card card = new Card();
        card.setCardStatus(CardStatus.ACTIVATED);
        card.setValidDate("01.01.2024");
        card.setStudent(student);

        student.setCard(card);

        studentRepository.save(student);
        return "Student Added";

    }

    @Override
    public UpdateStudentMobNoResponseDto updateMob(UpdateStudentMobRequestDto updateStudentMobRequestDto) throws StudentNotFoundException {
        Student student;
        try{
            student= studentRepository.findById(updateStudentMobRequestDto.getId()).get();
            student.setMobNo(updateStudentMobRequestDto.getMobNo());
            Student updatedStudent = studentRepository.save(student);
            UpdateStudentMobNoResponseDto updateStudentMobNoResponseDto = new UpdateStudentMobNoResponseDto();
            updateStudentMobNoResponseDto.setName(updatedStudent.getName());
            updateStudentMobNoResponseDto.setMobNo(updatedStudent.getMobNo());

            return updateStudentMobNoResponseDto;


        }
        catch (Exception e){
           throw new StudentNotFoundException("Invalid Student");
        }

    }

    @Override
    public Student getStudentById(int id) {
        return studentRepository.findById(id).get();
    }


}
