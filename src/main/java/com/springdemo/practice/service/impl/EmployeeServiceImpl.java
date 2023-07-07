package com.springdemo.practice.service.impl;

import com.springdemo.practice.entity.Employee;
import com.springdemo.practice.repository.EmployeeRepository;
import com.springdemo.practice.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    EmployeeRepository employeeRepository;
    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }


    @Override
    public List<Employee> findAll() {
        List<Employee> employees = employeeRepository.findAll();
        return employees;
    }

    @Override
    public Employee findById(Long employeeId) {
        Optional<Employee> employee = employeeRepository.findById(employeeId);
        return employee.get();
    }

    @Override
    public Employee save(Employee employee) {
        Employee dbEmployee = employeeRepository.save(employee);
        return dbEmployee;
    }

    @Override
    public String deleteById(Long employeeId) {
        employeeRepository.deleteById(employeeId);
        return "Employee deleted of id - "+employeeId;
    }
}
