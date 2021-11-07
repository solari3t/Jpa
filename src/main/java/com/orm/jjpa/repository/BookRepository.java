package com.orm.jjpa.repository;

import com.orm.jjpa.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface BookRepository extends JpaRepository<Book,Long> {

//    List<Book> deleteByBook_name(String book_name);
}
