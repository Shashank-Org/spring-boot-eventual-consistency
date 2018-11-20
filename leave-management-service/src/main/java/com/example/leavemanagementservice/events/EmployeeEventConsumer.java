package com.example.leavemanagementservice.events;

import com.example.leavemanagementservice.domain.EmployeeLeave;
import com.example.leavemanagementservice.service.EmployeeLeaveService;
import io.eventuate.tram.events.common.DomainEvent;
import io.eventuate.tram.events.subscriber.DomainEventEnvelope;
import io.eventuate.tram.events.subscriber.DomainEventHandlers;
import io.eventuate.tram.events.subscriber.DomainEventHandlersBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EmployeeEventConsumer {

    @Autowired
    private EmployeeLeaveService service;

    public DomainEventHandlers domainEventHandlers(){
        return DomainEventHandlersBuilder
            .forAggregateType("com.demo.hrmanagementservice.domain.Employee")
            .onEvent(EmployeeEvent.class, this::employeeEventEventHandler)
            .build();
    }

    private <E extends DomainEvent> void employeeEventEventHandler(DomainEventEnvelope<EmployeeEvent> domainEventEnvelope) {

        EventType eventType = domainEventEnvelope.getEvent().getEventType();
        EmployeeLeave employeeLeave = new EmployeeLeave();
        employeeLeave.setEmployeeId(domainEventEnvelope.getAggregateId());
        employeeLeave.setEmployeeName(domainEventEnvelope.getEvent().getEmployeeName());
        if(eventType==EventType.CREATED){
            System.out.println("Leave Registered for employee");
        }
        else if(eventType == EventType.UPDATED){
            System.out.println("Leave updated for employee");
        }
        else if(eventType == EventType.DELETED){
            System.out.println("Leave Deleted for employee");
        }
    }
}
