package com.demo.hrmanagementservice.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;

@Document
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee {
    @Id
    private String employeeId = UUID.randomUUID().toString();
    private String employeeName;
    private String address;
    private String contactNo;
}
