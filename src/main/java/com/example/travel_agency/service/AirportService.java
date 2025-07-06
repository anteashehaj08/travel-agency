package com.example.travel_agency.service;

import com.example.travel_agency.entities.Airport;
import com.example.travel_agency.entities.City;

import java.util.List;

public interface AirportService {
    Airport createAirport(Long cityId, String name);

    Airport update(String name, Long airportId, Long cityId);

    List<Airport> findAll();


    List<Airport> findByCity(Long cityId);

    Airport findById(Long Id);


    Airport getAllAirports();
}