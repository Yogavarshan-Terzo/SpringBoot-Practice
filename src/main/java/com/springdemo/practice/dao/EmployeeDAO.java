package com.springdemo.practice.dao;

import com.springdemo.practice.entity.Employee;

import java.util.List;

public interface EmployeeDAO {
    public List<Employee> findAll();

    Employee findById(int employeeId);

    Employee save(Employee employee);

    void deleteById(int employeeId);
}
