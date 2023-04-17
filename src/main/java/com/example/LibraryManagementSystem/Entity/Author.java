package com.example.LibraryManagementSystem.Entity;


import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "author")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    private int age;

    @Column(unique = true)

    private String email;

    @OneToMany(mappedBy = "author",cascade = CascadeType.ALL)
    List<Book>books = new ArrayList<>();




}
