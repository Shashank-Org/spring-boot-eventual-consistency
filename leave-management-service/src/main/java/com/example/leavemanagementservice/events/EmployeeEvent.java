package com.example.leavemanagementservice.events;

import io.eventuate.tram.events.common.DomainEvent;
import lombok.Data;


@Data
//@NoArgsConstructor
//@AllArgsConstructor
public class EmployeeEvent implements DomainEvent {
//    @Id
//    private String eventId = UUID.randomUUID().toString();
//    private String employeeId;
    private String employeeName;
    private EventType eventType;

    public EmployeeEvent(){}
    public EmployeeEvent(String employeeName,EventType eventType){
//        this.employeeId = employee.getEmployeeId();
        this.employeeName = employeeName;
        this.eventType = eventType;
    }
}