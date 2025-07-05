package com.example.travel_agency.repositories;

import com.example.travel_agency.entities.Continent;
import com.example.travel_agency.statics.ContinentEnum;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ContinentRepository extends JpaRepository<Continent,Long> {
    Optional<Continent> findByName(ContinentEnum name);

    boolean existsByNameIgnoreCase(String name);
}
