package com.example.travel_agency.service;

import com.example.travel_agency.entities.City;

import java.util.List;
import java.util.Optional;

public interface CityService {

    City createCity(String name, Long nationalityId);

    List<City> getAllCities();
    City getCityById(Long id);
    City updateCity(String name, Long cityId, Long countryId);
    City create(City city);
}
