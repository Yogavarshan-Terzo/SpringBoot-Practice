package com.springdemo.practice.service.impl;

import com.springdemo.practice.entity.Employee;
import com.springdemo.practice.repository.EmployeeRepository;
import com.springdemo.practice.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private EmployeeRepository employeeRepository;
    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee findById(int employeeId) {
        Optional<Employee> employee =employeeRepository.findById(employeeId);
        if(employee == null){
            throw  new RuntimeException("Employee id not found - "+employeeId);
        }
        return employee.get();
    }

    @Override
    @Transactional
    public Employee save(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    @Transactional
    public void deleteById(int employeeId) {
        employeeRepository.deleteById(employeeId);
    }
}
