package com.example.travel_agency.service.impl;

import com.example.travel_agency.entities.Airport;
import com.example.travel_agency.entities.City;
import com.example.travel_agency.repositories.AirportRepository;
import com.example.travel_agency.repositories.CityRepository;
import com.example.travel_agency.service.AirportService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@Data
public class AirportServiceImpl implements AirportService {
    @Autowired
    private AirportRepository airportRepository;
    @Autowired
    private CityRepository cityRepository;
    @Override
    public Airport create(Long cityId, String name){
        City city = cityRepository.findById(cityId).orElseThrow();
        Airport airport = new Airport();
        airport.setName(name);
        airport.setCity(city);
        return airportRepository.save(airport);
    }

    @Override
    public Airport update(String name,Long airportId, Long cityId) {
       Airport airport = this.findById(airportId);
       airport.setName(name);
       if(!airport.getCity().getId().equals(cityId)){{
           City city = cityRepository.findById(cityId).orElseThrow();
           airport.setCity(city);
       }
       return airportRepository.save(airport);
       }
    }

    @Override
    public List<Airport> findAll() {
        return null;
    }

    @Override
    public List<Airport> findByCity(City city) {
        return null;
    }
    @Override
    public Airport findById(Long Id){
        return airportRepository.findById().orElseThrow();
    }
}

