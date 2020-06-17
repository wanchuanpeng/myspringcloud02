package com.learning.example.springcloud02.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class EurekaServerApplication8763 {
    
    public static void main(String[] args) {
        SpringApplication.run(EurekaServerApplication8763.class, args);
    }
}