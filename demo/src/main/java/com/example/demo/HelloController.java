package com.example.demo;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class HelloController {

    @GetMapping("/hello")
    public String hello() {
        return "Hello World!";
    }

    private final MovieService movieService;

    @Autowired
    private AddressVerificationService addressVerificationService;


    public HelloController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping("/movies")
    public String getMovies() {
        return movieService.getMovies();
    }

    @GetMapping("/verify-address")
    public String verifyAddress(@RequestParam String address) throws IOException {
        return addressVerificationService.verifyAddress(address);
    }

}
