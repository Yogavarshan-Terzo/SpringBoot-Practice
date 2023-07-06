package com.springdemo.practice.dao.impl;

import com.springdemo.practice.dao.EmployeeDAO;
import com.springdemo.practice.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {
    private EntityManager entityManager;
    @Autowired
    public EmployeeDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public EmployeeDAOImpl() {
    }

    @Override
    public List<Employee> findAll() {
        //create a query
        TypedQuery<Employee> query = entityManager.createQuery("FROM Employee", Employee.class);
        //execute the query and get result list
        List<Employee> employees = query.getResultList();
        //return the result list
        return employees;
    }

    @Override
    public Employee findById(int employeeId) {
        return entityManager.find(Employee.class,employeeId);
    }

    @Override
    public Employee save(Employee employee) {
        return entityManager.merge(employee);
    }

    @Override
    public void deleteById(int employeeId) {
        Employee employee = entityManager.find(Employee.class,employeeId);
        entityManager.remove(employee);
    }
}
