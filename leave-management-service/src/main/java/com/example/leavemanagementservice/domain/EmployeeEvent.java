package com.example.leavemanagementservice.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;

import java.util.UUID;

@Data
@AllArgsConstructor
public class EmployeeEvent {
    @Id
    private String eventId = UUID.randomUUID().toString();
    private String employeeId;
    private String employeeName;
    private EventType eventType;

    public EmployeeEvent(){}

}