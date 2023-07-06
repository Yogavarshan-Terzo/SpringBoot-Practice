package com.springdemo.practice.service;

import com.springdemo.practice.entity.Employee;

import java.util.List;

public interface EmployeeService {
    public List<Employee> findAll();

    Employee findById(int employeeId);

    Employee save(Employee employee);

    void deleteById(int employeeId);
}
