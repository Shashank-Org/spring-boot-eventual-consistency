package com.demo.hrmanagementservice.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = "com.demo.hrmanagementservice")
@EntityScan(basePackages = "com.demo.hrmanagementservice.domain")
@EnableJpaRepositories(basePackages = "com.demo.hrmanagementservice.repository")
public class HrManagementServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(HrManagementServiceApplication.class, args);
    }
}
