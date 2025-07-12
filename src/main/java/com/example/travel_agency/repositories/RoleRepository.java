package com.example.travel_agency.repositories;

import com.example.travel_agency.entities.Role;
import org.springframework.boot.BootstrapContext;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role,String> {
    Boolean existsByName(String name);
}
