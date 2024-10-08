
```markdown
# Demo Spring Boot Application

This is a simple Spring Boot application that demonstrates how to create RESTful web services and call external APIs.

## Prerequisites

- Java 17 or higher
- Gradle
- Internet connection

## Getting Started

### Clone the repository

```sh
git clone https://github.com/nisargdesai15/demo-spring-boot.git
cd demo-spring-boot
```

### Build the project

```sh
./gradlew build
```

### Run the application

```sh
./gradlew bootRun
```

### Access the endpoints

- Hello World: [http://localhost:8080/hello](http://localhost:8080/hello)
- Greet: [http://localhost:8080/greet?name=YourName](http://localhost:8080/greet?name=YourName)
- Movies: [http://localhost:8080/movies](http://localhost:8080/movies)

## Project Structure

- `src/main/java/com/example/demo/HelloController.java`: Contains the REST endpoints.
- `src/main/java/com/example/demo/MovieService.java`: Service to call the external movies API.
- `src/main/java/com/example/demo/DemoApplication.java`: Main application class.

## Additional Resources

- [Spring Boot Reference Documentation](https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/)
- [Spring Web](https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/#web)
- [Building a RESTful Web Service](https://spring.io/guides/gs/rest-service/)
- [Serving Web Content with Spring MVC](https://spring.io/guides/gs/serving-web-content/)
- [Building REST services with Spring](https://spring.io/guides/tutorials/rest/)
```

This `README.md` provides instructions on how to clone, build, and run the project, as well as how to access the available endpoints.