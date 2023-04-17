package com.example.LibraryManagementSystem.DTO.RequestDto.ResponseDto;

import com.example.LibraryManagementSystem.Enums.TransactionStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class IssueResponseBookDto {
    private String transactionNumber;

    private TransactionStatus transactionStatus;


    private String bookName;
}
