package com.learning.example.springcloud02.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class EurekaServerApplication8762 {
    
    public static void main(String[] args) {
        SpringApplication.run(EurekaServerApplication8762.class, args);
    }
}