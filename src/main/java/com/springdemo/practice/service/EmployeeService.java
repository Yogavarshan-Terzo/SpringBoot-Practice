package com.springdemo.practice.service;

import com.springdemo.practice.entity.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> findAll();

    Employee findById(Long employeeId);

    void save(Employee employee);

    String deleteById(Long employeeId);

    Employee merge(Employee employee);
}
