package com.demo.hrmanagementservice.events.listeners;

import com.demo.hrmanagementservice.domain.Employee;
import com.demo.hrmanagementservice.events.EmployeeEvent;
import com.demo.hrmanagementservice.events.EventType;
import com.demo.hrmanagementservice.utils.Sender;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.mongodb.core.mapping.event.AbstractMongoEventListener;
import org.springframework.data.mongodb.core.mapping.event.AfterSaveEvent;
import org.springframework.stereotype.Controller;

@Slf4j
@Controller
public class AfterSaveListener extends AbstractMongoEventListener<Employee> {

    @Value("${spring.kafka.topic.employee-leave}")
    private String topic;

    @Autowired
    private Sender sender;

    @Override
    public void onAfterSave(AfterSaveEvent<Employee> event) {
        log.info("onAfterSave event='{}'",event);

        EmployeeEvent employeeEvent = new EmployeeEvent(event.getSource(), EventType.CREATED);
        sender.send(employeeEvent);
    }
}
