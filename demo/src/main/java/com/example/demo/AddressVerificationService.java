package com.example.demo;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;

@Service
public class AddressVerificationService {

    private final RestTemplate restTemplate;

    private static final String CLIENT_ID = "your-usps-client-id";
    private static final String CLIENT_SECRET = "your-usps-client-secret";
    private static final String TOKEN_URL = "https://api.usps.com/oauth2/token";
    private static final String VERIFY_URL = "https://api.usps.com/verify";

    public AddressVerificationService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public String verifyAddress(String address) throws IOException {
        HttpHeaders tokenHeaders = new HttpHeaders();
        tokenHeaders.setContentType(org.springframework.http.MediaType.APPLICATION_FORM_URLENCODED);

        String tokenBody = "grant_type=client_credentials&client_id=" + CLIENT_ID + "&client_secret=" + CLIENT_SECRET;

        HttpEntity<String> tokenRequest = new HttpEntity<>(tokenBody, tokenHeaders);
        ResponseEntity<String> tokenResponse = restTemplate.exchange(TOKEN_URL, HttpMethod.POST, tokenRequest, String.class);

        if (!tokenResponse.getStatusCode().is2xxSuccessful()) {
            throw new IOException("Unexpected code " + tokenResponse.getStatusCode());
        }

        String token = new ObjectMapper().readValue(tokenResponse.getBody(),String.class);

        String addressJson = "{ \"address\": { \"address1\": \"123 Main St\", \"city\": \"Anytown\", \"state\": \"CA\", \"zip\": \"12345\" } }";

        // Step 2: Make the Address Verification Request
        HttpHeaders verifyHeaders = new HttpHeaders();
        verifyHeaders.setBearerAuth(token);
        verifyHeaders.setContentType(org.springframework.http.MediaType.APPLICATION_JSON);

        HttpEntity<String> verifyRequest = new HttpEntity<>(addressJson, verifyHeaders);
        ResponseEntity<String> verifyResponse = restTemplate.exchange(VERIFY_URL, HttpMethod.POST, verifyRequest, String.class);

        if (!verifyResponse.getStatusCode().is2xxSuccessful()) {
            throw new IOException("Unexpected code " + verifyResponse.getStatusCode());
        }

        // Handle the response
        return verifyResponse.getBody();
    }
}
