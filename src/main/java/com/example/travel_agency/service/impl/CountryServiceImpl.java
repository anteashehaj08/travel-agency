package com.example.travel_agency.service.impl;

import com.example.travel_agency.entities.Country;
import com.example.travel_agency.exceptions.TourException;
import com.example.travel_agency.repositories.CityRepository;
import com.example.travel_agency.repositories.ContinentRepository;
import com.example.travel_agency.repositories.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryServiceImpl {
    @Autowired
    private CountryRepository countryRepository;

    @Autowired
    private ContinentRepository continentRepository;

    private CityRepository cityRepository;

    public Country createCountry(String name, Long continentId) {
        Country newCountry = new Country();
        newCountry.setName(name);
        newCountry.setContinentMembership(continentRepository.findById(continentId).orElseThrow());
        return countryRepository.save(newCountry);
    }

    public List<Country> getAllCountries() {
        return countryRepository.findAll();
    }

    public Country getCountryById(Long id) {
        return countryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Country not found"));
    }

    public Country updateCountry(String name, Long countryId, Long continentId) {
        Country country = this.getCountryById(countryId);
        return null;
    }

}
