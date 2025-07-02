package com.example.travel_agency.config;

import com.example.travel_agency.entities.Role;
import com.example.travel_agency.repositories.RoleRepository;
import com.example.travel_agency.service.impl.UserServiceImpl;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


@Configuration
public class SecurityConfig {
    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    @Lazy
    private UserServiceImpl userService;

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @PostConstruct
    public void addRoles() {
        if (!roleRepository.existsById("ROLE_ADMIN")) {
            roleRepository.save(new Role("ROLE_ADMIN"));
        }
        if (!roleRepository.existsById("ROLE_USER")) {
            roleRepository.save(new Role("ROLE_USER"));
        }
    }

  /*@Bean
    public SecurityFilterChain filterChain(HttpSecurity http){

    }*/


}
