package com.example.testRedis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

import com.example.testRedis.model.Employee;
import com.example.testRedis.service.EmployeeService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping(value = "/api/redis/employee")
public class EmployeeController {
    private static final Logger logger = LoggerFactory.getLogger(EmployeeController.class);

    @Autowired
    EmployeeService service;

    //Save a new employee
    //URL - localhost/api/redis/employee
    @PostMapping
    public String save(@RequestBody final Employee employee){
        logger.info("Saving the new employee to the redis");
        service.save(employee);
        return "Successfully added. Employee with id= "+employee.getId();
    }

    public Map<String,Employee> findAll(){
        logger.info("Fetching all employees from the redis");
        final Map<String, Employee> employeeMap = service.findAll();
        //can also implement a sort function here in the backend.
        return employeeMap;
    }

    @GetMapping("/get/{id}")
    public Employee findById(@PathVariable("id") final String id){
        logger.info("Fetching employee with id= "+ id);
        return service.findById(id);
    }
    
    
    
}
