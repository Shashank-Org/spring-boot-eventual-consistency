package com.example.leavemanagementservice.config;

import io.eventuate.tram.consumer.kafka.TramConsumerKafkaConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(basePackages = "com.example.leavemanagementservice.repository")
@Import({TramConsumerKafkaConfiguration.class})
public class EventuateConfig {
}
