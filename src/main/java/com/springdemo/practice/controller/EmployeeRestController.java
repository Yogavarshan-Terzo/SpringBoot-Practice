package com.springdemo.practice.controller;

import com.springdemo.practice.entity.Employee;
import com.springdemo.practice.entity.Role;
import com.springdemo.practice.repository.RoleRepository;
import com.springdemo.practice.service.EmployeeService;
import com.springdemo.practice.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
public class EmployeeRestController {
    RoleService roleService;
    EmployeeService employeeService;
    @Autowired
    public EmployeeRestController(RoleService roleService, EmployeeService employeeService) {
        this.roleService = roleService;
        this.employeeService = employeeService;
    }

    @GetMapping("/employees")
    public List<Employee> findAll(){
        List<Employee> employees = employeeService.findAll();
        return employees;
    }

    @GetMapping("/employees/{employeeId}")
    public Employee findEmployee(@PathVariable Long employeeId){
        Employee employee = employeeService.findById(employeeId);
        return employee;
    }

    @PostMapping("/employees")
    public void addEmployee(@RequestBody Employee employee){
        employee.setRoles(Arrays.asList(roleService.getRoleById(1)));
        employeeService.save(employee);
    }

    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee employee){
        Employee dbEmployee = employeeService.merge(employee);
        return dbEmployee;
    }

    @DeleteMapping("/employees/{employeeId}")
    public String deleteEmployee(@PathVariable Long employeeId){
        return employeeService.deleteById(employeeId);
    }

    @GetMapping("/employees/set-admin/{employeeId}")
    public void setAdmin(@PathVariable Long employeeId){
        Employee employee = employeeService.findById(employeeId);
        List<Role> roles = new ArrayList<>();
        roles.add(roleService.getRoleById(3));
        employee.setRoles(roles);
        employeeService.save(employee);
    }
    @GetMapping("/employees/set-manager/{employeeId}")
    public void setManager(@PathVariable Long employeeId){
        Employee employee = employeeService.findById(employeeId);
        List<Role> roles = new ArrayList<>();
        roles.add(roleService.getRoleById(2));
        employee.setRoles(roles);
        employeeService.save(employee);
    }

}
