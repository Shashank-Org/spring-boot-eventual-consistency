package com.example.leavemanagementservice.config;

import com.example.leavemanagementservice.domain.EmployeeEvent;
import com.example.leavemanagementservice.domain.EmployeeLeave;
import com.example.leavemanagementservice.repository.EmployeeLeaveRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Controller;

import java.util.concurrent.CountDownLatch;

@Controller
@Slf4j
public class Receiver {

    @Autowired
    private EmployeeLeaveRepository repository;

    private CountDownLatch latch = new CountDownLatch(1);

    public CountDownLatch getLatch(){
        return this.latch;
    }

    @KafkaListener(topics = "${spring.kafka.topic.employee-leave}")
    public void receiveEmployee(EmployeeEvent employeeEvent){
        log.info("received payload='{}'", employeeEvent);
        latch.countDown();

        EmployeeLeave employeeLeave = new EmployeeLeave();
        employeeLeave.setEmployeeId(employeeEvent.getEmployeeId());
        employeeLeave.setEmployeeName(employeeEvent.getEmployeeName());
        repository.save(employeeLeave);
    }


}
