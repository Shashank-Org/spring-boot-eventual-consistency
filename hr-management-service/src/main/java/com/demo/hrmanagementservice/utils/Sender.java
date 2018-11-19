package com.demo.hrmanagementservice.utils;

import com.demo.hrmanagementservice.events.EmployeeEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;

@Slf4j
public class Sender {

    @Value("${spring.kafka.topic.employee-leave}")
    private String jsonTopic;

    @Autowired
    private KafkaTemplate<String, EmployeeEvent> kafkaTemplate;

    public void send(EmployeeEvent employeeEvent) {
        log.info("sending car='{}'", employeeEvent.toString());
        kafkaTemplate.send(jsonTopic, employeeEvent);
    }
}
