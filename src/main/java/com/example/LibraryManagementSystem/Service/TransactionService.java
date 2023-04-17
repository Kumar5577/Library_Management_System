package com.example.LibraryManagementSystem.Service;

import com.example.LibraryManagementSystem.DTO.RequestDto.ResponseDto.IssueRequestBookDto;
import com.example.LibraryManagementSystem.DTO.RequestDto.ResponseDto.IssueResponseBookDto;

public interface TransactionService {
    public IssueResponseBookDto issueBook(IssueRequestBookDto issueRequestBookDto) throws Exception;
}
