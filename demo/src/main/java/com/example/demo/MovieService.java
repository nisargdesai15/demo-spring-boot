package com.example.demo;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class MovieService {

    private final RestTemplate restTemplate;

    public MovieService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public String getMovies() {
        String url = "https://reactnative.dev/movies.json";
        return restTemplate.getForObject(url, String.class);
    }
}