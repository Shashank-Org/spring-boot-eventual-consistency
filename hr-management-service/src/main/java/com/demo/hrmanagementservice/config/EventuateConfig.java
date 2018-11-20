package com.demo.hrmanagementservice.config;

import io.eventuate.tram.events.publisher.TramEventsPublisherConfiguration;
import io.eventuate.tram.messaging.producer.jdbc.TramMessageProducerJdbcConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(basePackages = "com.demo.hrmanagementservice.repository")
@Import({TramMessageProducerJdbcConfiguration.class, TramEventsPublisherConfiguration.class})
public class EventuateConfig {
}
