package com.example.LibraryManagementSystem.Repository;

import com.example.LibraryManagementSystem.Entity.Author;
import com.example.LibraryManagementSystem.Service.AuthorService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface AuthorRepository extends JpaRepository<Author,Integer> {

     Author findByEmail(String email);

}
