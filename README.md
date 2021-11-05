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




