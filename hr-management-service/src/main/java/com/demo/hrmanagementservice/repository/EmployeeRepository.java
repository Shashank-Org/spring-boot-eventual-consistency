package com.demo.hrmanagementservice.repository;

import com.demo.hrmanagementservice.domain.Employee;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.CrudRepository;

public interface EmployeeRepository extends MongoRepository<Employee,String> {
}
