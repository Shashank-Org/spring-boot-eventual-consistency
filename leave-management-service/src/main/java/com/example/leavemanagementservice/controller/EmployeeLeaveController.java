package com.example.leavemanagementservice.controller;

import com.example.leavemanagementservice.domain.EmployeeLeave;
import com.example.leavemanagementservice.repository.EmployeeLeaveRepository;
import com.example.leavemanagementservice.service.EmployeeLeaveService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/empleave")
public class EmployeeLeaveController {

    private EmployeeLeaveService service;

    public EmployeeLeaveController(EmployeeLeaveService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<String> save(@RequestBody EmployeeLeave employeeLeave){

        EmployeeLeave employeeLeave1 = service.save(employeeLeave);
        if(employeeLeave1 != null){
            return ResponseEntity.ok("Employee Leave Saved.");
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .build();
    }

}
