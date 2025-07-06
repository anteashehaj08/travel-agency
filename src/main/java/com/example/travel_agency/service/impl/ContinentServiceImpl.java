package com.example.travel_agency.service.impl;

import com.example.travel_agency.entities.Continent;
import com.example.travel_agency.repositories.ContinentRepository;
import com.example.travel_agency.service.ContinentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Service;

@Service
public class ContinentServiceImpl implements ContinentService {
    @Autowired
    private ContinentRepository continentRepository;

}
