package org.melek.consumer.controller;


import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

public class WalterController {

    public String sampleMethod() {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        ResponseEntity<String> responseEntity = restTemplate.exchange(
                "http://localhost:8081",
                HttpMethod.GET,
                new HttpEntity<>(httpHeaders),
                String.class);
        return responseEntity.getBody();
    }
}
