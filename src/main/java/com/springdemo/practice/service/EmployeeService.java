package com.springdemo.practice.service;

import com.springdemo.practice.entity.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> findAll();

    Employee findById(Long employeeId);

    Employee save(Employee employee);

    String deleteById(Long employeeId);
}
