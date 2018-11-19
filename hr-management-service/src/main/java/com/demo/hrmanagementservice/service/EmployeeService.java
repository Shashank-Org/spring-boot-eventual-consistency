package com.demo.hrmanagementservice.service;

import com.demo.hrmanagementservice.domain.Employee;
import com.demo.hrmanagementservice.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    private EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    //To store or update
    public Employee register(Employee employee){
        return employeeRepository.save(employee);
    }

    public Optional<Employee> byId(String employeeId){
        return employeeRepository.findById(employeeId);
    }

    public List<Employee> all(){
        List<Employee> employees = new ArrayList<>();
        employeeRepository.findAll()
                .forEach(employee -> employees.add(employee));
        return employees;
    }

    public void delete(String employteeId){
        employeeRepository.deleteById(employteeId);
    }
}
