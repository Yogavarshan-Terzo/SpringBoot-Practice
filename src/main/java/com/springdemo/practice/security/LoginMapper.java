package com.springdemo.practice.security;

import com.springdemo.practice.dto.LoginDto;
import com.springdemo.practice.repository.EmployeeRepository;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

@Service
public class LoginMapper {
    UserDetailsService userDetailsService;
    EmployeeRepository employeeRepository;
    AuthenticationManager authenticationManager;
    @Autowired
    public LoginMapper(UserDetailsService userDetailsService, EmployeeRepository employeeRepository, AuthenticationManager authenticationManager) {
        this.userDetailsService = userDetailsService;
        this.employeeRepository = employeeRepository;
        this.authenticationManager = authenticationManager;
    }

    public String authenticate(LoginDto loginDto, HttpServletRequest request, HttpServletResponse response){
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(loginDto.getEmail(),loginDto.getPassword()));

            HttpSession session = request.getSession();
            session.setAttribute("authenticatedUser",loginDto.getEmail());
            return "authenticated";
        }
        catch (Exception exc){
            return "User not authenticated";
        }
    }
}
