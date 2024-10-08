package com.example.demo;




import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/hello")
    public String hello() {
        return "Hello World!";
    }

    private final MovieService movieService;

    public HelloController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping("/movies")
    public String getMovies() {
        return movieService.getMovies();
    }
}
