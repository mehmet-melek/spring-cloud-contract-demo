package org.melek.consumer.controller;


import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/check")
public class WalterController {

    private RestTemplate restTemplate = new RestTemplate();


    @GetMapping
    @ResponseBody()
    public String checkYourOwnName(@RequestParam(name = "name") String name) {

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.set(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE);

        UriComponentsBuilder builder = UriComponentsBuilder
                .fromHttpUrl("http://localhost:10010/whoTheHellAreYou")
                .queryParam("youKnow", name);

        ResponseEntity<String> declanResponse = restTemplate.exchange(
                builder.toUriString(),
                HttpMethod.GET,
                new HttpEntity<>(httpHeaders),
                String.class);

        return declanResponse.getBody().contains("Heisenberg") ? "Yee!" : "Noo!";
    }
}
