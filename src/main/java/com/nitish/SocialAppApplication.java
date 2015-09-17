package com.nitish;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@EnableAutoConfiguration
@EnableEurekaClient
public class SocialAppApplication {

    public static void main(String[] args) {
        System.setProperty("spring.config.name", "social-service");
        SpringApplication.run(SocialAppApplication.class, args);
    }
}
