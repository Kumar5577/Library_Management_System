package com.example.LibraryManagementSystem.DTO.RequestDto.ResponseDto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class IssueRequestBookDto {
    private int cardId;
    private int bookId;
}
