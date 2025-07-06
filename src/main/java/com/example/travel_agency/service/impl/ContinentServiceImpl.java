package com.example.travel_agency.service.impl;

import com.example.travel_agency.entities.Continent;
import com.example.travel_agency.repositories.ContinentRepository;
import com.example.travel_agency.service.ContinentService;
import com.example.travel_agency.statics.ContinentEnum;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class ContinentServiceImpl implements ContinentService {
    @Autowired
    private ContinentRepository continentRepository;

    @PostConstruct
    public void addContinents() {
        Arrays.stream(ContinentEnum.values()).forEach(enumVal -> {
            if (!continentRepository.existsByName(enumVal)) {
                Continent continent = new Continent();
                continent.setName(enumVal);
                continentRepository.save(continent);
            }
        });
    }

}
