package com.example.travel_agency.service.impl;

import com.example.travel_agency.entities.Continent;
import com.example.travel_agency.repositories.ContinentRepository;
import com.example.travel_agency.service.ContinentService;
import com.example.travel_agency.statics.ContinentEnum;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class ContinentServiceImpl implements ContinentService {
    @Autowired
    private ContinentRepository continentRepository;

    @Override
    public List<Continent> findAll(){
        return continentRepository.findAll();
    }

    @Override
    public Optional<Continent> findById(Long id){
        return continentRepository.findById(id);
    }

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
