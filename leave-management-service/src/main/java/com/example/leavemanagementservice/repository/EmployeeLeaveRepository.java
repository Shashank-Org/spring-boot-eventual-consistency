package com.example.leavemanagementservice.repository;

import com.example.leavemanagementservice.domain.EmployeeLeave;
import org.springframework.data.repository.CrudRepository;

public interface EmployeeLeaveRepository extends CrudRepository<EmployeeLeave,String> {

    EmployeeLeave findAllByEmployeeId(String employeeId);
}
