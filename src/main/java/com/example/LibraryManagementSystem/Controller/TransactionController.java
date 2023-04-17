package com.example.LibraryManagementSystem.Controller;

import com.example.LibraryManagementSystem.DTO.RequestDto.ResponseDto.IssueRequestBookDto;
import com.example.LibraryManagementSystem.DTO.RequestDto.ResponseDto.IssueResponseBookDto;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/transaction")
public class TransactionController {

    public IssueResponseBookDto issueBook(IssueRequestBookDto issueRequestBookDto){

    }

}
