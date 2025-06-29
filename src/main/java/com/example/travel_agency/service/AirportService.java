package com.example.travel_agency.service;

import com.example.travel_agency.entities.Airport;
import com.example.travel_agency.entities.City;

import java.util.List;

public interface AirportService {
    Airport create(Airport airport);
    Airport update(Airport airport);
    Airport findById(Long Id);
    List<Airport> findAll();
    List<Airport> findByCity(City city);
}
