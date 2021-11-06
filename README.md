## Jpa 
## Day1

### 1. orm(object-relational mapping)
> #### meaning
> orm is a technique that lets you query and manipulate data from a datasource using an object-oriented paradigm
> 
> orm lib is a lib written in your language of choice that encapsulates the code needed to manipulate the data, so there is no need to use SQL anymore
> 

>  #### pros 
>1. DRY(Don repeat yourself)  
    &nbsp; model of orm is written in only one place   , so it is easy to update, maintain and reusable
>2. some features(transactions, connection pooling,migrations) could use immediately

>  #### cons
>1. some services need to use sql(fail to compete against SQL queries for complex queries)
>2. more difficult as much as project complicates
> 
### 2. jpa(Java Persistence API)
> #### meaning
> &nbsp; provides java developers with an orm facility for managing data in Java applications  
> 
### 3. Srping Data JPA
> #### meaning
> is part of Spring Data , makes it easy to easily implement JPA based repositories.
> it makes easier to build spring application uses data access tech
> 
> #### features
> • support to build repositories based on Spring and JPA
> • transparent auditing of domain  
> • validation  
> • pagination support, dynamic query execution, ability to integrate custom data access code  
> • etc

### 1. orm(object-relational mapping)
> #### meaning
> orm 은 관계형데이터베이스의 데이터를 객체와 매핑해주는 것이다.
>
> orm 라이브러리는 개발자가 선택한 개발언어로 코딩하여 구현한 객체를 데이터 테이블과 매핑하기 때문에 sql 문을 작성하지 않고 데이터를 핸들링할수 있다.
>

>  #### 장점
>1. 트랜잭션 , 커넥션 풀, 마이그래이션 기능을 사용할수 있다.
>2. DRY(Don repeat yourself)  
    &nbsp; 모델은 독립적으로 한 곳에 작성되기 때문에 , 유지보수, 재사용을 쉽게 할 수 있다. 


>  #### 딘점
>1. 복잡한 쿼리는 sql을 사용이 불가피 하다.
>2. 프로젝트의 난이도가 올라갈 수록 난이도가 올라간다.
>
### 2. jpa(Java Persistence API)
> #### meaning
> &nbsp; 자바어플리케이션에서 orm 기능을 제공한다.
>
### 3. Srping Data JPA
> #### meaning
>  Spring Data 의 요소 중 하나로 , jpa 기반 repository 적용을 쉽게 해준다 .
>  jpa로 데이터를 핸들링하는 스프링 어플리케이션을 쉽게 생성한다. 
>
> #### 기능
> • 스프링 및 jpa 기반 repository를 생성
> • domain 을 투명하게 점검
> • 유효성확인  
> • 페이지기능, 동적쿼리실행  
> • 등등



## Day2

### 1. Model
```java
    import javax.persistence.*;
    @Entity
    @Table(name="books")
    @Data
    public class Book{
    
        @Id
        @GeneratedValue 
        private Long id;
        
        @NotNull
        @Column(name="bookName") // needed when field name not match column name
        private String book_name ;    
        
        @NotNull
        private String author_name;
        
        @NotNull
        private String isbn;
        
        
    }

```
#### • @GeneratedValue
 to generate primary key value automatically, there are 4 generation types 
 

1. Auto (Default)
2. IDENTITY
3. SEQUENCE
4. TABLE

#### Auto Generation

the persistence provider will determine values basesd on **type** of the primary key attribute. could be numeric or UUID.

&nbsp; generation of numeric is based on a sequence or table generator

```java
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Book {
    @Id
    @GeneratedValue
    private long id;
    // pk would be unique value at db
    // ...
    
}
```

&nbsp; UUID will use *UUID Generator*
    
> *UUID Generator* is one of new feature in Hibernate 5.
> 
> To use this, declare id of type **UUID** with **@GeneratedValue**

```java
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.UUID;

@Entity
public class Book {
    @Id
    @GeneratedValue
    private UUID id;
    
    // hibernate would generate an id of the form "8dd5f315-9788-4d00-87bb-10eed9eff566"

}
```

<br>


#### Identity Generation

&nbsp; uses *IdentityGenerator* expects values generated by an *identity* column in db, values are auto-incremented.

```java
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // it disables batch updates
    private long id;
}
```

<br>

#### Sequence Generation

&nbsp; use *SequenceStyleGenerator*, Generator would uses sequences if database provides them, or switches to table generation.

&nbsp; for customization, use @GenericGenerator with  SequenceStyleGenerator strategy

```java
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Book {
    @Id
    @GeneratedValue(generator = "sequence-generator")
    @GenericGenerator(
            name = "sequence-generator",
            strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
            parameters = {
                    @Parameter(name = "sequence_name", value = "book_sequence"),
                    @Parameter(name = "initial_value" , value = "4"), // pk would start at 4 
                    @Parameter(name = "increment_size", value = "1") // increase 1 per seq 
            }
    )
    private long id;
    // values are unique per seq
}
```

<br>

#### Table Generation

&nbsp; use tables to generate id, table hold the latest sequence value, employ row-level locking to prevent concurrent connections to acquire same values.  

&nbsp; it sounds like we must use row-level locking, but it is transactional , and once acquired , it can only be released when the current transaction done (commit or rollback)

&nbsp; if duration of transaction is longer than expect , it could be terrible issue cuz it would prevent any other transaction from acquiring a new sequence value.

&nbsp; so sequence , identity generation would be better choice.


