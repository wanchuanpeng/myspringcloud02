package com.learning.example.springcloud02.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
@EnableEurekaClient
@EnableFeignClients(basePackages= {"com.learning.example.springcloud02"})
@ComponentScan("com.learning.example.springcloud02")
public class ConsumerFeignApplication8081 {
    
    public static void main(String[] args) {
        SpringApplication.run(ConsumerFeignApplication8081.class, args);
    }
}