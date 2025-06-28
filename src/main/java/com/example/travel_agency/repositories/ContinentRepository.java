package com.example.travel_agency.repositories;

import com.example.travel_agency.entities.Continent;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContinentRepository extends JpaRepository<Continent,Long> {
}
