package ru.snakesnake.spring.springboot.spring_project.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.snakesnake.spring.springboot.spring_project.model.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByRole(String role);
}
