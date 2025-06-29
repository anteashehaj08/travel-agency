package com.example.travel_agency.service.impl;

import com.example.travel_agency.entities.City;
import com.example.travel_agency.entities.Country;
import com.example.travel_agency.repositories.CityRepository;
import com.example.travel_agency.repositories.CountryRepository;
import com.example.travel_agency.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CityServiceImpl implements CityService {
    @Autowired
    private CityRepository cityRepository;
    @Autowired
    private CountryRepository countryRepository;

    @Override
    public City createCity(String name, Long nationalityId) {
        Country country = countryRepository.findById(nationalityId)
                .orElseThrow(()-> new RuntimeException("Country not found"));
        City city = new City();
        city.setName(name);
        city.setNationality(country);
        return cityRepository.save(city);
    }

    @Override
    public List<City> getAllCities() {
        return cityRepository.findAll();
    }

    @Override
    public City getCityById(Long id) {
        return cityRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("City not found"));
    }

    @Override
    public City updateCity(String name, Long cityId, Long countryId) {
        City city = this.getCityById(cityId);
        if (!city.getNationality().getCountryId().equals(countryId)) {
            Country country = countryRepository.findById(countryId)
                    .orElseThrow(()-> new RuntimeException("Country not found"));
            city.setNationality(country);
        }
        city.setName(name != null ? name : city.getName());
        return cityRepository.save(city);
    }
}
