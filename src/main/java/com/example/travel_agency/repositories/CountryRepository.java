package com.example.travel_agency.repositories;

import com.example.travel_agency.entities.Country;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryRepository extends JpaRepository<Country, Long> {

}
