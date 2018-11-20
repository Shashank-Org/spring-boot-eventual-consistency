package com.demo.hrmanagementservice.controller;

import com.demo.hrmanagementservice.domain.Employee;
import com.demo.hrmanagementservice.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    private EmployeeService service;

    public EmployeeController(EmployeeService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<String> register(@RequestBody Employee employee){
        Employee employee1 = service.register(employee);
        if(employee1 != null){
            return ResponseEntity.ok("Employee Registered");
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .build();
    }

    @PutMapping
    public ResponseEntity<String> update(@RequestBody Employee employee){
        Employee employee1 = service.update(employee);
        if(employee1 != null){
            return ResponseEntity.ok("Employee updated");
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .build();
    }

    @DeleteMapping
    public ResponseEntity<String> delete(@RequestBody Employee employee){
        service.delete(employee);
        return ResponseEntity.ok("Employee Deleted.");
    }

    @GetMapping("/{employeeId}")
    public ResponseEntity<Employee> getOne(@PathVariable String employeeId){
        Optional<Employee> employeeOptional = service.byId(employeeId);
        if(employeeOptional.isPresent()){
            return ResponseEntity.ok(employeeOptional.get());
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping
    public ResponseEntity<List<Employee>> getAll(){
        return ResponseEntity.ok(service.all());
    }
}
