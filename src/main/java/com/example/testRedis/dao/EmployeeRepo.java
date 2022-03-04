package com.example.testRedis.dao;

import java.util.Map;

import com.example.testRedis.model.Employee;

import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepo {
    
    //Save a new employee
    void save(Employee employee);

    //Find employee by id
    Employee findById(String id);

    //Find all employees
    Map<String, Employee> findAll();

    //Delete a employee.
    void delete(String id);

}
