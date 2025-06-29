package com.example.travel_agency.service.impl;

import com.example.travel_agency.entities.Airport;
import com.example.travel_agency.repositories.AirportRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class AirportServiceImpl {
    @Autowired
    private AirportRepository airportRepository;
    @Override
    public Airport create(Airport airport){
        return airportRepository.save(airport);

    }
    @Override
    public List<Airport>
    }
}
