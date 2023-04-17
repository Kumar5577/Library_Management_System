package com.example.LibraryManagementSystem.Controller;


import com.example.LibraryManagementSystem.Entity.Book;
import com.example.LibraryManagementSystem.Service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/book")
public class BookController {

    @Autowired
    BookService bookService;
    @PostMapping(value = "/add")

    public String addBook(@RequestBody Book book) throws Exception {
      return bookService.addBook(book);

      // find all the books
        // find all the books of a particular authorid

        // find all the books written by a particular author
    }
}
