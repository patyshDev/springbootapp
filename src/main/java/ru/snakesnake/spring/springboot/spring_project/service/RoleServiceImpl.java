package ru.snakesnake.spring.springboot.spring_project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.snakesnake.spring.springboot.spring_project.dao.RoleRepository;
import ru.snakesnake.spring.springboot.spring_project.model.Role;

import java.util.List;

@Service
public class RoleServiceImpl {
    @Autowired
    RoleRepository roleRepository;

    public List<Role> getAllRoles() {
        return roleRepository.findAll();
    }

    public Role getRoleByName(String name) {
        return roleRepository.findByRole(name);
    }

}
