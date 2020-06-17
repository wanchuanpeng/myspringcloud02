package com.learning.example.springcloud02.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
@EnableHystrixDashboard
public class ConsumerHystrisDashboardApplication {
    
    public static void main(String[] args) {
        SpringApplication.run(ConsumerHystrisDashboardApplication.class, args);
    }
}