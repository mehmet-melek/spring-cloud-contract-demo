package org.melek.producer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class DeclanProviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(DeclanProviderApplication.class, args);
    }


}