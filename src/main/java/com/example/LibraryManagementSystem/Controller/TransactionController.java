package com.example.LibraryManagementSystem.Controller;

import com.example.LibraryManagementSystem.DTO.RequestDto.ResponseDto.IssueRequestBookDto;
import com.example.LibraryManagementSystem.DTO.RequestDto.ResponseDto.IssueResponseBookDto;
import com.example.LibraryManagementSystem.Service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/transaction")
public class TransactionController {

    @Autowired
    TransactionService transactionService;

    @PostMapping("/add")
    public IssueResponseBookDto issueBook(IssueRequestBookDto issueRequestBookDto) throws Exception {
    return transactionService.issueBook(issueRequestBookDto);

    }

}
