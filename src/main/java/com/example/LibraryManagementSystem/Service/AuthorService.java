package com.example.LibraryManagementSystem.Service;

import com.example.LibraryManagementSystem.DTO.RequestDto.ResponseDto.AuthorResponseDto;
import com.example.LibraryManagementSystem.Entity.Author;
import com.example.LibraryManagementSystem.Repository.AuthorRepository;

public interface AuthorService {
    public String addAuthor(Author author);
    public AuthorResponseDto getByEmail(String email);
}
