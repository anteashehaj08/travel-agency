package com.example.travel_agency.service;


import com.example.travel_agency.entities.Continent;

import java.util.List;
import java.util.Optional;

public interface ContinentService {


    List<Continent> findAll();

    Optional<Continent> findById(Long id);
}
