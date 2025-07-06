package com.example.travel_agency.service.impl;


import com.example.travel_agency.entities.Role;
import com.example.travel_agency.entities.User;
import com.example.travel_agency.exceptions.TourException;
import com.example.travel_agency.repositories.RoleRepository;
import com.example.travel_agency.repositories.UserRepository;
import com.example.travel_agency.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;
    @Autowired
    private RoleRepository roleRepository;
    @Override
    public User create(User user) {
        if (userRepository.existsByUsername(user.getUsername())) {
            throw TourException.userExists(user.getUsername());
        } else {
            user.setPassword(passwordEncoder.encode(user.getPassword()));
        }
        return userRepository.save(user);
    }
    @Override
    public User register(User user) {
        if (userRepository.existsByUsername(user.getUsername())) {
            throw TourException.userExists(user.getUsername());
        } else {
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            user.setRole((Role) roleRepository.findById("ROLE_USER").get());
        }
        return userRepository.save(user);
    }

}
