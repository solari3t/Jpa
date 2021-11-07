package com.orm.jjpa.controller;

import com.orm.jjpa.exception.BookNotFoundException;
import com.orm.jjpa.model.Book;
import com.orm.jjpa.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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
    public Book createNote(@Valid @RequestBody Book book){
        return bookRepository.save(book);
    }
    @GetMapping("/books/{id}")
    public Book getNoteById(@PathVariable(value = "id") Long id) throws  BookNotFoundException{
        return bookRepository.findById(id)
                .orElseThrow(() -> new BookNotFoundException(id));
    }
    @PutMapping("/books/{id}")
    public Book updateNote(@PathVariable(value = "id") Long id,@Valid @RequestBody Book bookDetails) throws BookNotFoundException{
        Book book = bookRepository.findById(id)
                .orElseThrow(()-> new BookNotFoundException(id));
        book.setBookName(bookDetails.getBookName());
        book.setAuthor_name(bookDetails.getAuthor_name());
        book.setIsbn(bookDetails.getIsbn());
        Book updatedBook = bookRepository.save(book);
        return updatedBook;

    }
}
