package com.orm.jjpa.service;

import com.orm.jjpa.exception.BookNotFoundException;
import com.orm.jjpa.model.Book;
import com.orm.jjpa.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService{
    @Autowired
    BookRepository bookRepository;

    @Override
    public List<Book> bookList() {
        return bookRepository.findAll();
    }

    @Override
    public Book createBook(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public Book updateBook(Long id, Book bookDetails) throws BookNotFoundException {
        Book book = getBookById(id);
        book.setBookName(bookDetails.getBookName());
        book.setAuthor_name(bookDetails.getAuthor_name());
        book.setIsbn(bookDetails.getIsbn());
        return bookRepository.save(book);
    }

    @Override
    public Book getBookById(Long id) throws BookNotFoundException{
        return bookRepository.findById(id).orElseThrow(()->new BookNotFoundException(id));
    }

    @Override
    public void deleteBookById(Long id) {
        bookRepository.deleteById(id);
    }
}
