package com.clinic.cardio;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

// TODO: Enable Security
@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
public class CardioApplication {

    public static void main(String[] args) {
        SpringApplication.run(CardioApplication.class, args);
    }
}
