package com.springdemo.practice.dto;

import com.springdemo.practice.entity.Employee;
import com.springdemo.practice.entity.Role;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class UserDetailsDto implements UserDetails {

    private Long id;
    private String name;
    private String email;
    private String designation;
    private String password;
    private List<Role> roles;
    private List<GrantedAuthority> authorities;
    private Boolean active;
    public UserDetailsDto(Employee employee) {
        this.id= employee.getId();
        this.email= employee.getEmail();
        this.password= employee.getPassword();
        this.active=true;
        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
        this.roles = employee.getRoles();
        String[] authStrings ;
        authStrings = IntStream.range(0, roles.size())
                .mapToObj(i -> roles.get(i).getRole())
                .toArray(String[]::new);
        authorities = Arrays.stream(authStrings)
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toList());
        this.authorities=authorities;
    }
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return name;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return active;
    }
}
