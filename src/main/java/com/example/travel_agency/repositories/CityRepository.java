package com.example.travel_agency.repositories;

import com.example.travel_agency.entities.City;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CityRepository extends JpaRepository<City, Long> {
    Optional<City> findByName(City name);
}
