package ru.snakesnake.spring.springboot.spring_project.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ru.snakesnake.spring.springboot.spring_project.dao.UserRepository;
import ru.snakesnake.spring.springboot.spring_project.model.User;

@Service
public class SecurityServiceImpl implements UserDetailsService {

    private final UserRepository userRepository;

    public SecurityServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(email);

        return user;
    }
}
