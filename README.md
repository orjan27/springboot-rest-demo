# springboot-rest-demo

Spring Boot CRUD demo is demonstrating how to implement simple CRUD operations with an `Employee` entity using REST API. 
API's can be consumed by any JS libraries/frameworks. I have created a separate repo for angular code for the frontend. Please download https://github.com/orjan27/my-new-angular-project for the frontend.

## What's inside 
This project is based on the [Spring Boot](http://projects.spring.io/spring-boot/) project and uses these packages :
- Maven
- Spring Core
- Spring Data (Hibernate & MySQL)
- Spring MVC (Tomcat)

## Installation 
The project is created with Maven, so you just need to import it to your IDE and build the project to resolve the dependencies

## Database configuration 
Create a MySQL database with the name `springbootdb` and add the credentials to `/resources/application.properties`.  
The default ones are :

```
spring.datasource.url=jdbc:mysql://localhost/springbootdb
spring.datasource.username=root
spring.datasource.password=
spring.jpa.hibernate.ddl-auto=update
```
 Note: All tables needed for the project will be automatically created. We just need to create the database specified in "spring.datasource.url".

 If in any case the tables are not created upon running springboot. Kindly do import the tables manually, see springbootdb.sql

## Usage 
Run the project through the IDE and head out to [http://localhost:8080](http://localhost:8080)

or 

run this command in the command line:
```
mvn spring-boot:run
```
