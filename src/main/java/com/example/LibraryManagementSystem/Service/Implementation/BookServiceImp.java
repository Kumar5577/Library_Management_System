package com.example.LibraryManagementSystem.Service.Implementation;

import com.example.LibraryManagementSystem.Entity.Author;
import com.example.LibraryManagementSystem.Entity.Book;
import com.example.LibraryManagementSystem.Repository.AuthorRepository;
import com.example.LibraryManagementSystem.Service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImp implements BookService {
    @Autowired
    AuthorRepository authorRepository;
    @Override
    public String addBook(Book book) throws Exception {
        Author author;
        try {
             author = authorRepository.findById(book.getAuthor().getAge()).get();
        }
        catch(Exception e){
            throw new Exception("Author Not Present");
        }
        author.getBooks().add(book);
        book.setAuthor(author);
        authorRepository.save(author);
        return "Book Added";
    }
}
