package com.orm.jjpa.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name="books")
@ToString
@Getter
@Setter
@NoArgsConstructor(access =  AccessLevel.PROTECTED)
@EqualsAndHashCode(of ={"id","isbn"})
public class Book {
    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "book_name")
    private String bookName;

    private String author_name;

    private String isbn;


}