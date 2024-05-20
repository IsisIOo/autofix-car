package com.example.autofixcar;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;


@SpringBootApplication
@EnableDiscoveryClient
public class AutofixCarApplication {

    public static void main(String[] args) {
        SpringApplication.run(AutofixCarApplication.class, args);
    }

}
