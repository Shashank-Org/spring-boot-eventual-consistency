package com.example.leavemanagementservice.service;

import com.example.leavemanagementservice.domain.EmployeeLeave;
import com.example.leavemanagementservice.repository.EmployeeLeaveRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EmployeeLeaveService {

    private EmployeeLeaveRepository repository;


    public EmployeeLeaveService(EmployeeLeaveRepository repository) {
        this.repository = repository;
    }

    public EmployeeLeave save(EmployeeLeave employeeLeave){
        return repository.save(employeeLeave);
    }

    public Optional<EmployeeLeave> byId(String employeeLeaveId){
        return repository.findById(employeeLeaveId);
    }

    public EmployeeLeave byEmployeeId(String employeeId){
        return repository.findAllByEmployeeId(employeeId);
    }
}
