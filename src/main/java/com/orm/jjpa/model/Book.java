package com.orm.jjpa.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name="books")
@ToString
@Getter
@NoArgsConstructor(access =  AccessLevel.PROTECTED)
@EqualsAndHashCode(of ={"id","isbn"})
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name= "book_name",nullable = false)
    private String book_name;

    @Column(name = "author_name", nullable = false)
    private String author_name;

    @Column(name = "isbn" , nullable = false)
    private String isbn;


}