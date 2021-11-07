package com.orm.jjpa.service;


import com.orm.jjpa.exception.BookNotFoundException;
import com.orm.jjpa.model.Book;

import java.util.List;

public interface BookService {
    List<Book> bookList();
    Book createBook(Book book);
    Book updateBook(Long id ,Book book) throws BookNotFoundException;
    Book getBookById(Long id) throws BookNotFoundException;
    void deleteBookById(Long id);
}
