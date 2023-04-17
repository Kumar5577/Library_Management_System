package com.example.LibraryManagementSystem.Service.Implementation;

import com.example.LibraryManagementSystem.DTO.RequestDto.ResponseDto.IssueRequestBookDto;
import com.example.LibraryManagementSystem.DTO.RequestDto.ResponseDto.IssueResponseBookDto;
import com.example.LibraryManagementSystem.Entity.Book;
import com.example.LibraryManagementSystem.Entity.Card;
import com.example.LibraryManagementSystem.Entity.Transaction;
import com.example.LibraryManagementSystem.Enums.CardStatus;
import com.example.LibraryManagementSystem.Enums.TransactionStatus;
import com.example.LibraryManagementSystem.Repository.BookRepository;
import com.example.LibraryManagementSystem.Repository.CardRepository;
import com.example.LibraryManagementSystem.Repository.TransactionRepository;
import com.example.LibraryManagementSystem.Service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class TransactionServiceImp implements TransactionService {

    @Autowired
    CardRepository cardRepository;

    @Autowired
    BookRepository bookRepository;

    @Autowired
    TransactionRepository transactionRepository;

    @Override
    public IssueResponseBookDto issueBook(IssueRequestBookDto issueRequestBookDto) throws Exception {

        Transaction transaction = new Transaction();
        transaction.setTransactionNumber(String.valueOf(UUID.randomUUID()));
        transaction.setIssuedOperation(true);

        Card card;
        try{
            card = cardRepository.findById(issueRequestBookDto.getCardId()).get();
        }
        catch (Exception e ){
            transaction.setTransactionStatus(TransactionStatus.FAILED);
            transactionRepository.save(transaction);
            throw new Exception("Invalid Card");
        }

        transaction.setCard(card);

        Book book;
        try{
            book = bookRepository.findById(issueRequestBookDto.getBookId()).get();
        }
        catch (Exception e){
            transaction.setTransactionStatus(TransactionStatus.FAILED);
            transactionRepository.save(transaction);
            throw new Exception("Invalid Book");
        }

        transaction.setBook(book);

        if(card.getCardStatus()!= CardStatus.ACTIVATED){
            transaction.setTransactionStatus(TransactionStatus.FAILED);
            transactionRepository.save(transaction);
            throw new Exception("Card is Not Activate !!");
        }
        if(book.isIssued()){
            transaction.setTransactionStatus(TransactionStatus.FAILED);
            transactionRepository.save(transaction);
            throw new Exception("Book Is Not Available");
        }

        transaction.setTransactionStatus(TransactionStatus.SUCCESS);
        book.setIssued(true);
        book.setCard(card);
        book.getTransactionList().add(transaction);
        card.getBooksIssued().add(book);
        card.getTransactionList().add(transaction);

        cardRepository.save(card);

        // prepare response DTO

        IssueResponseBookDto issueResponseBookDto = new IssueResponseBookDto();
        issueResponseBookDto.setBookName(book.getTitle());
        issueResponseBookDto.setTransactionNumber(transaction.getTransactionNumber());
        issueResponseBookDto.setTransactionStatus(transaction.getTransactionStatus());

        // returnBook API
        return issueResponseBookDto;




    }
}
