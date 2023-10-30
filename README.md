# Spring Work Accounting App

This app was developed to calculate
employee salaries (without taxation) and record efficiency,
as well as track employees working hours.

## Reference Documentation
For further reference, please consider the following sections:

* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/3.1.3/maven-plugin/reference/html/)
* [Spring Web](https://docs.spring.io/spring-boot/docs/3.1.3/reference/htmlsingle/index.html#web)
* [Validation](https://docs.spring.io/spring-boot/docs/3.1.3/reference/htmlsingle/index.html#io.validation)
* [Spring Data JPA](https://docs.spring.io/spring-boot/docs/3.1.3/reference/htmlsingle/index.html#data.sql.jpa-and-spring-data)

## Getting Started

In order to get started, you will need Apache Maven, JDK 17 (or higher) installed,
and one of the IDEs of your choice. For example, you can use Intellij IDEA 2022.2.4 Ultimate,
JDK 17 coretto (Amazon Coretto version 17.0.9).
Then, after cloning the project on your device, you need to build pom.xml,
after which, when Maven installs the dependencies, you are good to go.

## Running the tests

All test are located in a src/test folder.
Every test is located in the same directory as a class they are testing.
The util folder contains a class with constants for tests and a class with objects for testing.
To run test you can use Maven test or simply right click on folder test and then choose Run "All tests"

## Examples

Application use MVC REST architecture. It means that you can access data throughout controllers
and all data will be passed using JSON format. Authorization is implemented using JWT token.  
You can register using this link - http://localhost:8080/auth/register.  
And you can authenticate using this link - http://localhost:8080/auth/login.  
Now when you received you token you can access your controllers without any issues.

## Deployment

Before deployment make sure that all tests are passed and your have your app as a .jar file in target directory.

There is Dockerfile to create an image of your app and docker-compose for creating container,
that will contain your db and app .jar file. 

## Authors
- **Parhomchik Nikita** - *Initial work* - [MrKravz](https://github.com/MrKravz)


