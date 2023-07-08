package com.springdemo.practice.security;

import com.springdemo.practice.dto.UserDetailsDto;
import com.springdemo.practice.entity.Employee;
import com.springdemo.practice.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsService implements org.springframework.security.core.userdetails.UserDetailsService {
    private EmployeeRepository employeeRepository;
    @Autowired
    public UserDetailsService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Employee employee = employeeRepository.findByEmail(username);
        if(employee == null){
            return null;
        }
        return new UserDetailsDto(employee);
    }
}
