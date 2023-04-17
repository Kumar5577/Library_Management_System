package com.example.LibraryManagementSystem.Service.Implementation;

import com.example.LibraryManagementSystem.DTO.RequestDto.ResponseDto.AuthorResponseDto;
import com.example.LibraryManagementSystem.Entity.Author;
import com.example.LibraryManagementSystem.Repository.AuthorRepository;
import com.example.LibraryManagementSystem.Service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthorServiceImp implements AuthorService {

    @Autowired
    AuthorRepository authorRepository;
    @Override
    public String addAuthor(Author author){
     authorRepository.save(author);
     return "Author added";
    }
    @Override
    public AuthorResponseDto getByEmail(String email) {
        Author author = authorRepository.findByEmail(email);
        AuthorResponseDto authorResponseDto = new AuthorResponseDto();
        authorResponseDto.setName(author.getName());
        authorResponseDto.setAge(author.getAge());
        return authorResponseDto;
    }

}
