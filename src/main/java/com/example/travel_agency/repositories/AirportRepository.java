package com.example.travel_agency.repositories;

import com.example.travel_agency.entities.Airport;
import com.example.travel_agency.entities.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AirportRepository extends JpaRepository<Airport, Long> {
@Query(value = "Select a from Airport a where lower(a.city)= lower(:city)")
List<Airport> findAllByCity_Id(Long cityId);
Airport findByName(String name);
}
