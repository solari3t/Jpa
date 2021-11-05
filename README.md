## Jpa 
## Day1

### 1. orm(object-relational mapping)
> #### meaning
> orm is a technique that lets you query and manipulate data from a datasource using an object-oriented paradigm
> 
> orm lib is a lib written in your language of choice that encapsulates the code needed to manipulate the data, so there is no need to use SQL anymore
> 

>  #### pros 
>1. some features(transactions, connection pooling,migrations) could use immediately
>2. DRY(Don repeat yourself)  
    &nbsp; model of orm is written in only one place   , so it is easy to update, maintain and reusable
>3. some features(transactions, connection pooling,migrations) could use immediately

>  #### cons
>1. some services need to use sql(fail to compete against SQL queries for complex queries)
>2. more difficult as much as project complicates
> 
### 2. jpa(Java Persistence API)
> ####meaning
> &nbsp; provides java developers with an orm facility fro managing data in Java applications  
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


