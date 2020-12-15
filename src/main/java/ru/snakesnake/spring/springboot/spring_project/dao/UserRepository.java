package ru.snakesnake.spring.springboot.spring_project.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.snakesnake.spring.springboot.spring_project.model.User;


public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);
}
