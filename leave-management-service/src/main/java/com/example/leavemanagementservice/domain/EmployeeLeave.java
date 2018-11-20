package com.example.leavemanagementservice.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.UUID;

//@Document
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeLeave {
    @Id
    private String employeeLeaveId = UUID.randomUUID().toString();
    private String employeeId;
    private String employeeName;
    private int casualLeaveCount = 12;
    private int sickLeaveCount = 10;
    private int otherLeaveCount = 5;
}
