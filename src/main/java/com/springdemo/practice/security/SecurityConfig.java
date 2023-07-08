package com.springdemo.practice.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@SuppressWarnings("removal")
public class SecurityConfig {
    RequestFilter requestFilter;
    @Autowired
    public SecurityConfig(RequestFilter requestFilter) {
        this.requestFilter = requestFilter;
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
        http.csrf().disable();
        http.authorizeHttpRequests(authorize ->
                authorize
                        .requestMatchers("/login").permitAll()
                        .requestMatchers(HttpMethod.GET,"/employees","/employees/**").hasRole("EMPLOYEE")
                        .requestMatchers(HttpMethod.POST,"/employees").hasRole("MANAGER")
                        .requestMatchers(HttpMethod.PUT,"/employees").hasRole("MANAGER")
                        .requestMatchers(HttpMethod.DELETE,"/employees").hasRole("ADMIN")
                        .anyRequest().authenticated()
        )
                .logout().disable();
        http.addFilterBefore(requestFilter, UsernamePasswordAuthenticationFilter.class);
        return http.build();
    }
}
