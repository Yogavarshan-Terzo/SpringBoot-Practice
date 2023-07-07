package com.springdemo.practice.service.impl;

import com.springdemo.practice.entity.Role;
import com.springdemo.practice.repository.RoleRepository;
import com.springdemo.practice.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements RoleService {
    RoleRepository roleRepository;
    @Autowired
    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public Role getRoleById(int id) {
        Role role = roleRepository.getReferenceById(id);
        return role;
    }
}
