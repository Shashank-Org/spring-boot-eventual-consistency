package com.demo.hrmanagementservice.config;

import com.demo.hrmanagementservice.config.kafka.KafkaSenderConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@ComponentScan(basePackages = "com.demo.hrmanagementservice")
@EntityScan(basePackages = "com.demo.hrmanagementservice.domain")
@EnableMongoRepositories(basePackages = "com.demo.hrmanagementservice.repository")
@Import(KafkaSenderConfig.class)
public class HrManagementServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(HrManagementServiceApplication.class, args);
    }
}
