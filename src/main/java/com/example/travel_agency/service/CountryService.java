package com.example.travel_agency.service;


import com.example.travel_agency.entities.Country;

public interface CountryService {
  Country createCountry(String name, Long countryId);
  Country updateCountry(String name, Long countryId,Long continentId);
  Country getCountryById(Long countryId);
}
