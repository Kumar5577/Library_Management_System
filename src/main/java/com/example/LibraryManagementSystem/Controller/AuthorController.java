package com.example.LibraryManagementSystem.Controller;


import com.example.LibraryManagementSystem.DTO.RequestDto.ResponseDto.AuthorResponseDto;
import com.example.LibraryManagementSystem.Entity.Author;
import com.example.LibraryManagementSystem.Service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/author")
public class AuthorController {
    @Autowired
    AuthorService authorService;
    @PostMapping(value = "/add")
    public String addAuthor(@RequestBody Author author){
     return authorService.addAuthor(author);

        // Delete an author by id
        // update an author buy id
        // find an author by id
        // find all the authors
    }
    @GetMapping("/get_by_email")
    public AuthorResponseDto getAuthorByEmail(@RequestParam("email") String email){
        return authorService.getByEmail(email);
    }
}
