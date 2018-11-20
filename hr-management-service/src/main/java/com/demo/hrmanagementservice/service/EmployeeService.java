package com.demo.hrmanagementservice.service;

import com.demo.hrmanagementservice.domain.Employee;
import com.demo.hrmanagementservice.events.EmployeeEvent;
import com.demo.hrmanagementservice.events.EventType;
import com.demo.hrmanagementservice.repository.EmployeeRepository;
import io.eventuate.tram.events.publisher.DomainEventPublisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private DomainEventPublisher publisher;

    public Employee register(Employee employee){

        Employee savedEmployee = employeeRepository.save(employee);
        publisher.publish(Employee.class,employee.getEmployeeId(),
                Arrays.asList(new EmployeeEvent(employee.getEmployeeName()
                        , EventType.CREATED)));
        return savedEmployee;
    }

    public Employee update(Employee employee){

        Employee updatedEmployee = employeeRepository.save(employee);
        publisher.publish(Employee.class,employee.getEmployeeId(),
                Arrays.asList(new EmployeeEvent(employee.getEmployeeName()
                        , EventType.UPDATED)));
        return updatedEmployee;
    }

    public void delete(Employee employee){
        employeeRepository.deleteById(employee.getEmployeeId());
        publisher.publish(Employee.class,employee.getEmployeeId(),
                Arrays.asList(new EmployeeEvent(employee.getEmployeeName()
                        ,EventType.DELETED)));
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
}
