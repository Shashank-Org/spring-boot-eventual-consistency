package com.example.leavemanagementservice.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@ComponentScan(basePackages = "com.example.leavemanagementservice")
@EntityScan(basePackages = "com.example.leavemanagementservice.domain")
@EnableMongoRepositories(basePackages = "com.example.leavemanagementservice.repository")
@Import(KafkaConsumerConfig.class)
public class LeaveManagementServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(LeaveManagementServiceApplication.class, args);
    }
}
