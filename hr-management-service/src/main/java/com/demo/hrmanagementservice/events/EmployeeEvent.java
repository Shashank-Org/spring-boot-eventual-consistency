package com.demo.hrmanagementservice.events;

import com.demo.hrmanagementservice.domain.Employee;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;

@Document
@Data
//@NoArgsConstructor
@AllArgsConstructor
public class EmployeeEvent {
    @Id
    private String eventId = UUID.randomUUID().toString();
    private String employeeId;
    private String employeeName;
    private EventType eventType;

    public EmployeeEvent(){}
    public EmployeeEvent(Employee employee,EventType eventType){
        this.employeeId = employee.getEmployeeId();
        this.employeeName = employee.getEmployeeName();
        this.eventType = eventType;
    }
}