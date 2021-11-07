package com.orm.jjpa.test;

import com.orm.jjpa.repository.BookRepository;
import javafx.application.Application;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class BookTest {
    @Autowired
    BookRepository bookRepository;

    @Test
    public void deleteTest(){
//        System.out.println(bookRepository.getById(Long.parseLong("1")));

    }
}
