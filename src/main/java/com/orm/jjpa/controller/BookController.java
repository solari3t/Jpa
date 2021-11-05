package com.orm.jjpa.controller;

import com.orm.jjpa.model.Book;
import com.orm.jjpa.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BookController {
    @Autowired
    BookRepository bookRepository;

    @GetMapping("/books")
    public List<Book> getAllNotes(){
        return bookRepository.findAll();
    }

    @PostMapping("/books")
    public Book createNote(@Valid @RequestBody Book book)
}
